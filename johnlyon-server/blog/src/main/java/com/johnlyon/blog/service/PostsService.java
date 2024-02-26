package com.johnlyon.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.johnlyon.blog.mapper.PostsMapper;
import com.johnlyon.blog.mapper.PostsPageMapper;
import com.johnlyon.blog.pojo.Posts;
import com.johnlyon.blog.pojo.PostsPage;
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
            posts.setTitle(title);
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

    public void editPosts(String url,
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
            posts.setTitle(title);
            posts.setDate(date);
            posts.setIntroduction(introduction);
            posts.setPin(pin);

            PostsPage postsPage = new PostsPage();
            postsPage.setUrl(url);
            postsPage.setName(name);
            postsPage.setTitle(title);
            postsPage.setDate(date);
            postsPage.setContent(content);

            QueryWrapper<Posts> postsUpdateWrapper = new QueryWrapper<>();
            postsUpdateWrapper.eq("name", name);

            QueryWrapper<PostsPage> postsPageUpdateWrapper = new QueryWrapper<>();
            postsPageUpdateWrapper.eq("name", name);

            int affectedRowsPosts = postsMapper.update(posts, postsUpdateWrapper);
            int affectedRowsPostsPage = postsPageMapper.update(postsPage, postsPageUpdateWrapper);
            if (affectedRowsPosts == 0 || affectedRowsPostsPage == 0) {
                throw new IllegalArgumentException("Error: No rows affected.");
            }

        } else {
            throw new IllegalArgumentException("Error: Parameters cannot be null or empty.");
        }
    }

    public void deletePosts(String name) {
        if (name != null && !name.isEmpty()) {
            QueryWrapper<PostsPage> postsPageDeleteWrapper = new QueryWrapper<>();
            postsPageDeleteWrapper.eq("name", name);

            QueryWrapper<Posts> postsDeleteWrapper = new QueryWrapper<>();
            postsDeleteWrapper.eq("name", name);



            int affectedRowsPostsPage = postsPageMapper.delete(postsPageDeleteWrapper);
            int affectedRowsPosts = postsMapper.delete(postsDeleteWrapper);
            if (affectedRowsPosts == 0 || affectedRowsPostsPage == 0) {
                throw new IllegalArgumentException("Error: No rows affected.");
            }
        } else {
            throw new IllegalArgumentException("Error: Parameters cannot be null or empty.");
        }
    }
}
