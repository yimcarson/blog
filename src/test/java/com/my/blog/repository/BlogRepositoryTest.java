package com.my.blog.repository;

import com.my.blog.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void testSave() {
        blogRepository.save(new Blog.Builder()
                .title("Test")
                .content("Hello World!")
                .isDelete(false)
                .build());
    }
}
