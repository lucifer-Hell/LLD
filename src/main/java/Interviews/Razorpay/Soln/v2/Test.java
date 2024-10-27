package Interviews.Razorpay.Soln.v2;

import java.util.*;
import java.util.stream.Collectors;

// Models

class Blog{
        String id;
        String raw;
        Set<String> words;
        Date createdAt;
        boolean deleted;

        Blog(String text){
            if(text.isEmpty() || text.isBlank()) throw new RuntimeException("Cannot provide empty string");
            this.raw=text;
            this.words=new HashSet<>(List.of(text.split(" ")));
            this.createdAt=new Date();
        }

        void prettyPrint(){
            System.out.println("------");
            System.out.println("Blog id : "+this.id);
            System.out.println("Blog raw text : "+this.raw);
            System.out.println("Blog createdAt : "+this.createdAt.toString());
            System.out.println("------");
        }
}

enum BlogEventType{
        BLOG_CREATED,
        BLOG_UPDATED,
        BLOG_DELETED;
}

class BlogEvent{
    final String blogId;
    final BlogEventType blogEventType;
    final Blog blog;
    BlogEvent(String blogId,BlogEventType blogEventType,Blog blog){
        this.blogId=blogId;
        this.blogEventType=blogEventType;
        this.blog=blog;
    }
}
// Repositories
class BlogRepository{
        private final HashMap<String,Blog> map;
        private static BlogRepository instance;
        private BlogRepository(){
            this.map=new HashMap<>();
        }
        public static BlogRepository getInstance(){
            if(instance==null){
                instance=new BlogRepository();
            }
            return instance;
        }
        Optional<Blog> findBlogById(String id){
            Blog blog= map.getOrDefault(id, null);
            if(blog!=null && !blog.deleted) return Optional.of(blog);
            else return Optional.empty();
        };
        Blog updateBlog(String id,Blog updatedBlog){
            if(map.containsKey(id) && !map.get(id).deleted){
                // update blog
                map.put(id,updatedBlog);
                return updatedBlog;
            }else throw new RuntimeException("Blog with provided id not found");
        };
        Blog saveBlog(Blog blog){
            if(map.containsKey(blog.id)){
                throw new RuntimeException("Blog already present");
            }else{
                blog.id=RandomGenerator.generateRandomId("BLOG-");
                map.put(blog.id,blog);
                return blog;
            }
        };

        void deleteBlog(String id){
            if(map.containsKey(id)){
                Blog blog=map.get(id);
                blog.deleted= true;
                map.put(id,blog);
            }else throw new RuntimeException("No blog found with given id");
        };
}
// UTILS
class RandomGenerator{
    public static String generateRandomId(String prefix){
        return prefix+UUID.randomUUID().toString();
    }
}


//## Services :
interface BlogEventObserver{
    void handleBlogEvent(BlogEvent blogEvent);
}

class BlogService{
        List<BlogEventObserver> observers;
        BlogRepository blogRepository;
        BlogService(BlogRepository blogRepository){
            this.blogRepository=blogRepository;
            observers=new ArrayList<>();
        }
        Blog addBlog(Blog blog){
            Blog createdBlog=blogRepository.saveBlog(blog);
            BlogEvent blogEvent=new BlogEvent(createdBlog.id,BlogEventType.BLOG_CREATED,createdBlog);
            notifyObservers(blogEvent);
            return createdBlog;
        }

        Optional<Blog> getBlogById(String id){
            return blogRepository.findBlogById(id);
        }

        Blog updateBlog(String id ,Blog blog){
           Blog updatedBlog= blogRepository.updateBlog(id,blog);
           notifyObservers(new BlogEvent(
                   id,BlogEventType.BLOG_UPDATED,updatedBlog
           ));
           return updatedBlog;
        }
        void deleteBlog(String id){
            Blog blog=blogRepository.findBlogById(id).get();
           blogRepository.deleteBlog(id);
           notifyObservers(new BlogEvent(
                   id,BlogEventType.BLOG_DELETED,blog
           ));
        }
        void notifyObservers(BlogEvent blogEvent){
            observers.forEach(observer->observer.handleBlogEvent(
                    blogEvent
            ));
        }
        BlogEventObserver addObserver(BlogEventObserver observer){
            if(!observers.contains(observer)){
                observers.add(observer);
            }
            return observer;
        }
        void removeObserver(BlogEventObserver observer){
            observers.remove(observer);
        }

}

interface SortStrategy {
    List<Blog> sort(List<Blog> blogs);
}

class SortByCreatedDate implements SortStrategy{

    @Override
    public List<Blog> sort(List<Blog> blogs) {
        List<Blog> sortedList=new ArrayList<>(blogs);
        sortedList.sort(Comparator.comparing(a -> a.createdAt));
        return sortedList;
    }
}

class SearchService implements BlogEventObserver{
    HashMap<String,Set<String>> wordIdsMap;
    BlogService blogService;
    SortStrategy sortStrategy;
    SearchService(BlogService blogService){
        this.blogService=blogService;
        this.sortStrategy = new SortByCreatedDate();
        wordIdsMap=new HashMap<>();
    }

    private void insertBlog(String blogId) {
        Blog blog=blogService.getBlogById(blogId).get();
        List<String> words= List.of(blog.raw.split(" "));
        for(String word: words){
            if(word.isBlank() || word.isEmpty()) continue;
            Set<String> ids=wordIdsMap.getOrDefault(word,new HashSet<>());
            ids.add(blog.id);
            wordIdsMap.put(word,ids);
        }
    }

    private void deleteBlog(Blog blog) {
        List<String> words= List.of(blog.raw.split(" "));
        for(String word: words){
            if(word.isBlank() || word.isEmpty()) continue;
            Set<String> ids=wordIdsMap.getOrDefault(word,new HashSet<>());
            ids.remove(blog.id);
            wordIdsMap.put(word,ids);
        }
    }

    private void updateBlog(String blogId) {
        Blog blog=blogService.getBlogById(blogId).get();
        // can improve the approach but for now going with naive
        HashMap<String,HashSet<String>> updatedMap=new HashMap<>();
        for(String key: wordIdsMap.keySet()){
            Set<String> ids=wordIdsMap.get(key);
            ids.remove(blog.id);
            wordIdsMap.put(key,ids);
        }
    }

    public void setSortStrategy(SortStrategy sortStrategy){
            this.sortStrategy=sortStrategy;
    }
    public List<Blog> searchBlog(List<String> keywords){
            // base case
            if(keywords.isEmpty()) return new ArrayList<>();
            Set<String> resultBlogIds=new HashSet<>(wordIdsMap.get(keywords.get(0)));
            if(resultBlogIds.isEmpty()) return new ArrayList<>();
            // keep eliminating blog ids which doesn't contain all the words
            for(int i=1;i<keywords.size() && !resultBlogIds.isEmpty();i++){
                String keyword=keywords.get(i);
                // if word is not present simply return empty list
                if(!wordIdsMap.containsKey(keyword)) return new ArrayList<>();
                Set<String> idList=wordIdsMap.get(keyword);
                // keep filtering blog ids
                Set<String> updatedIds=new HashSet<>();
                resultBlogIds.forEach(id->{
                    if(idList.contains(id))
                        updatedIds.add(id);
                });
                resultBlogIds=updatedIds;
            }
            List<Blog> results=resultBlogIds.stream()
                    .map(blogId->blogService.getBlogById(blogId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            return sortStrategy.sort(results);
        }
        List<Blog>searchBlog(String input){
            if(input==null || input.isEmpty() || input.isBlank()) throw new RuntimeException("invalid search key provided ");
            return searchBlog(List.of(input.split(" ")));
        }

    @Override
    public void handleBlogEvent(BlogEvent blogEvent) {
        BlogEventType event=blogEvent.blogEventType;
        String blogId=blogEvent.blogId;
        Blog blog=blogEvent.blog;
        // update blog in search map
        if(event.equals(BlogEventType.BLOG_CREATED)){
            System.out.println("processing blog in word map");
            insertBlog(blogId);
        }
        else if(event.equals(BlogEventType.BLOG_UPDATED)){
            System.out.println("updating blog in word map");
            updateBlog(blogId);
        }
        else if(event.equals(BlogEventType.BLOG_DELETED)){
            System.out.println("deleting blog in word map");
            deleteBlog(blog);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        BlogRepository blogRepository= BlogRepository.getInstance();
        BlogService blogService=new BlogService(blogRepository);
        SearchService searchService=new SearchService(blogService);
        // add search service as observer for any events happening to blog service
        blogService.addObserver(searchService);
        Blog blog1=new Blog("AI IS EVERYWHERE ");
        blogService.addBlog(blog1);
        Blog blog2=new Blog("AI WILL KILL EVERYWHERE JOB");
        blogService.addBlog(blog2);
        Blog blog3=new Blog("AI IS CHUTIYA");
        blogService.addBlog(blog3);
        System.out.println("------ TEST CASE - 1 ------");
        searchService.searchBlog("AI")
                .forEach(Blog::prettyPrint); ;// should print all above 3 in ordered way by creation date
        System.out.println("------ TEST CASE - 2 ------");
        searchService.searchBlog("AI EVERYWHERE ")
                .forEach(Blog::prettyPrint); ;// should print only 2 blog 1,2 results in ordered way by creation date
        blogService.deleteBlog(blog2.id);
        System.out.println("------ TEST CASE - 3 ------");
        searchService.searchBlog("AI EVERYWHERE ")
                .forEach(Blog::prettyPrint); ;// should print only 1 result blog 1 in ordered way by creation date
        System.out.println("------ TEST CASE - 4 ------");
        searchService.searchBlog("AI IS ")
                .forEach(Blog::prettyPrint); ;// should print only 2 result blog 1 ,3 in ordered way by creation date
        Blog blog4=new Blog("MGRS ARE NAZI");
        blogService.addBlog(blog4);
        Blog blog5=new Blog("ALL MGRS ARE WORTHLESS");
        blogService.addBlog(blog5);
        System.out.println("------ TEST CASE - 5 ------");
        searchService.searchBlog("MGRS")
                .forEach(Blog::prettyPrint); ;// should print only 2 result blog 4,5 in ordered way by creation date
        blogService.deleteBlog(blog5.id);
        System.out.println("------ TEST CASE - 6 ------");
        searchService.searchBlog("MGRS")
                .forEach(Blog::prettyPrint); ;// should print only 1 result blog 4 in ordered way by creation date
        System.out.println("------ TEST CASE - 7 ------");
        searchService.setSortStrategy((list)->
             list.stream().sorted(Comparator.comparing(a->a.raw)).toList()
        ); // functional interface approach sorting based on text lexicographically
        searchService.searchBlog("AI")
                .forEach(Blog::prettyPrint); ;// should print only result blog 1,3 in ordered way by creation date

        /*
        *  Using observer pattern for notifying search service for change in blog from blog service
           Using singleton pattern to replicate the single db instance ( blog repository case )
           Using strategy pattern to sort the search results based on the given strategy
        * */
    }
}
