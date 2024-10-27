<h3>
    Your organization has started a new tech blog with
    interesting tech stories and you’re responsible for designing and implementing
    an in-memory search engine, supporting the search functionality on the blog content.


Requirements:</h3>
<li>It should be possible to create a dataset in the search engine.</li>
<li>It should be possible to insert and delete documents in a given dataset. Each document is simply a piece of text.</li>
<li>It should be possible to search through documents for a search pattern in a given dataset.</li>
<li>It should be possible to order the search results </li>

# Soln : 

## Models : 
### Blog
    String id
    String raw
    Set<String> words
    Date createdAt;
    boolean deleted;
## Event:
    BLOG_CREATED
    BLOG_UPDATED
    BLOG_DELETED
## Repositories:
### BlogRepository
    HashMap<String,Blog> map;
    Optional<Blog> findBlogById(id)
    Blog updateBlog(id,Blog blog)
    Blog saveBlog(Blog blog)
    void deleteBlog(id)
## Services : 
### BlogService
    List<Observer> observers
    BlogRepository blogRepository
    BlogService(blogRepository)
    addBlog(Blog blog)
        - created Blog object 
        - store in db
        - notifyObservers(id,BLOG_CREATED)
    getBlogById(String id)
        - get from db
    updateBlog(String id ,Blog blog)
        - update in blog db
        - notifyObservers(id,BLOG_UPDATED)
    deleteBlog(String id)
        - delete in blog db
        - notifyObservers(id,BLOG_DELTED)
    notifyObservers(String id,Event eventType)
        - update all observers
    addObserver(Observer observer)
    removeObserver(Observer observer)
    
### SearchService
    HashMap<String,Set<String>> wordIdsMap;
    BlogService blogService;
    OrderStrategy sortStrategy;
    SearchService(blogService,sortStrategy)
    void handleBlogUpdateEvent(String blogId,Event event)
        - update blog in search map
    List<Blog> searchBlog(List<String> keywords,OrderStrategy sortStrategy)
    searchBlog(String input,Filter filter,OrderStrategy sortStrategy)
## OrderStrategy
    List<Blog> order(List<Blog> blog) 

## Design Patterns Using
    Using observer pattern for notifying search service for change in blog from blog service
    Using singleton pattern to replicate the single db instance ( blog repository case )
    Using strategy pattern to sort the search results based on the given strategy