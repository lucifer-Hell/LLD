package Interviews.Razorpay;

import java.util.Comparator;
import java.util.List;

public class OrderByCreatedAt implements OrderStrategy {

    @Override
    public List<Blog> sort(List<Blog> blogs) {
        blogs.sort(Comparator.comparing(a -> a.createdAt));
        return blogs;
    }
}
