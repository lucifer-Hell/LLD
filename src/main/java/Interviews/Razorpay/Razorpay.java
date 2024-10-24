



package Interviews.Razorpay;

import java.util.*;
import java.util.stream.Collectors;

public class Razorpay {

    /*
    Your organization has started a new tech blog with
    interesting tech stories and you’re responsible for designing and implementing
    an in-memory search engine, supporting the search functionality on the blog content.
Requirements:
-----
It should be possible to create a dataset in the search engine.
It should be possible to insert and delete documents in a given dataset. Each document is simply a piece of text.
It should be possible to search through documents for a search pattern in a given dataset.
It should be possible to order the search results
-----

this is a blog
this is our pattern -- <is , list< ids > >
-
Entities :
Blog { id , text, createdAt }  -- model  -- done
BlogRepostiory -- repository  -- done
    - getBlogById()
searchService -- service
      search(String str) // is this
OrderStrategy
blogService -- service
     insert
     delete

---

     */
    public static void main(String[] args) {
        BlogServiceDemo blogServiceDemo=new BlogServiceDemo();
        OrderStrategy orderStrategy=new OrderByCreatedAt();
//        blogServiceDemo.addBlog("this is a blog");
//        blogServiceDemo.addBlog("hello");
//        blogServiceDemo.addBlog("this is a test");
//        blogServiceDemo.addBlog("hello interview");
        Blog blog1= blogServiceDemo.addBlog("apple is a fruit");
        Blog blog2=blogServiceDemo.addBlog("apple, apple come on!");
        System.out.println("before removal : "+blogServiceDemo.searchBlogs("apple",orderStrategy));
        blogServiceDemo.removeBlog(blog1.id);
        blogServiceDemo.addBlog("apple, come on!");
        blogServiceDemo.addBlog("oranges are sour");
        blogServiceDemo.addBlog("apple-pie is sweet");
        System.out.println("after removal : "+blogServiceDemo.searchBlogs("apple",orderStrategy));
//        System.out.println(blogServiceDemo.searchBlogs("this is",orderStrategy));
//        System.out.println(blogServiceDemo.searchBlogs(" hello interview",orderStrategy));
//        System.out.println(blogServiceDemo.searchBlogs("this is",orderStrategy));

    }
}

class Blog {
    String id;
    String text;
    Date createdAt;

    Blog(String s){
        this.text=s;
        this.createdAt=new Date();
    }
}
class BlogRepository{
    static BlogRepository instance;
    HashMap<String , Blog> db;
    BlogRepository(){
        this.db=new HashMap<>();
    }

    public BlogRepository getInstance(){
        if(instance==null) instance=new BlogRepository();
        return instance;
    }

    Blog insert(Blog blog){
        // GENERATE RANDOM ID
        blog.id=("BLOG-"+generateId());
        // ADD BLOG IN DB
        db.put(blog.id,blog);
        return blog;
    }

    private String generateId(){
        return UUID.randomUUID().toString();
    }

    Blog getBlogById(String id){
        return db.get(id);
    }

    void delete(String id){
        if(db.containsKey(id)){
            db.remove(id);
        }
        else throw new RuntimeException("Key not present");
    }
}

interface OrderStrategy{
    List<Blog> sort(List<Blog> blogs);
};

class SearchService{
    HashMap<String, Set<String>> searchDb;
    SearchService(){
        this.searchDb=new HashMap<>();
    }

    List<String> find(String searchKey){
        if(searchKey.isEmpty()) return new ArrayList<>();
        List<String> searchWords= List.of(searchKey.split(" "));
        Set<String> results=new HashSet<>();
        // THIS IS A WORD
        // SEARCH KEY : WORD IS
        // < WORD , [1]>
        // < IS , [1]>
        for(String word: searchWords)
            if(searchDb.containsKey(word) && !searchDb.get(word).isEmpty()){
                results.addAll(searchDb.get(word));
            }
        return new ArrayList<>(results);
    }

    void addBlog(Blog blog){
        List<String> words= List.of(blog.text.split(" "));
        for(String word : words){
            // update word
            if(searchDb.containsKey(word)){
                searchDb.get(word).add(blog.id);
            }else{
                HashSet<String> set=new HashSet<>();
                set.add(blog.id);
                searchDb.put(word,set);
            }
        }
    }

    void removeBlog(Blog blog){
        List<String> words= List.of(blog.text.split(" "));
        for(String word : words){
            // update word
            if(searchDb.containsKey(word)){
                searchDb.get(word).remove(blog.id);
            }
        }
    }
}

class BlogService{
    BlogRepository blogRepository;
    BlogService(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }
    Blog addBlog(String s){
        return blogRepository.getInstance().insert(new Blog(s));
    }
    void removeBlog(String id){
        blogRepository.getInstance().delete(id);
    }
}

class BlogServiceDemo{
    private  SearchService searchService;
    private  BlogRepository blogRepoitory ;
    private BlogService blogService;

    private OrderStrategy orderStrategy;

    BlogServiceDemo(){
        this.searchService=new SearchService();
        this.blogRepoitory=new BlogRepository();
        this.blogService=new BlogService(blogRepoitory);
    }
    Blog addBlog(String blog){
       Blog result= blogService.addBlog(blog);
       // remove from search service
       searchService.addBlog(result);
       return result;
    }
    void removeBlog(String id){
        Blog blog=blogRepoitory.getInstance().getBlogById(id);
        blogService.removeBlog(id);
        searchService.removeBlog(blog);
    }
    List<String> searchBlogs(String searchKey,OrderStrategy orderStrategy){
        List<String> blogIds= searchService.find(searchKey);
        List<Blog> sortedBlogs=new ArrayList<>();
        for (String blogId : blogIds) {
            sortedBlogs.add(blogRepoitory.getInstance().getBlogById(blogId));
        }
        sortedBlogs= orderStrategy.sort(sortedBlogs);
        return sortedBlogs.stream().map(blog -> blog.text).collect(Collectors.toList());
    }
}



/*
searchService -- service
      search(String str) // is this
OrderStrategy
 */

