package com.johnlyon.blog.service;

import com.johnlyon.blog.mapper.PostsMapper;
import com.johnlyon.blog.mapper.PostsPageMapper;
import com.johnlyon.blog.pojo.Posts;
import com.johnlyon.blog.pojo.PostsPage;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    @Autowired
    private PostsMapper postsMapper;
    @Autowired
    private PostsPageMapper postsPageMapper;

    public void addPosts(String url,
                         String name,
                         String title,
                         String date,
                         String introduction,
                         String content,
                         Integer pin) {
        if (url != null && !url.isEmpty()
                && name != null && !name.isEmpty()
                && title != null && !title.isEmpty()
                && date != null && !date.isEmpty()
                && introduction != null && !introduction.isEmpty()
                && content != null && !content.isEmpty()
        ) {
            Posts posts = new Posts();
            posts.setUrl(url);
            posts.setName(name);
            posts.setDate(date);
            posts.setIntroduction(introduction);
            posts.setPin(pin);

            PostsPage postsPage = new PostsPage();
            postsPage.setUrl(url);
            postsPage.setName(name);
            postsPage.setTitle(title);
            postsPage.setDate(date);
            postsPage.setContent(content);

            postsMapper.insert(posts);
            postsPageMapper.insert(postsPage);

        } else {
            throw new IllegalArgumentException("Error: Parameters cannot be null or empty.");
        }
    }
}
