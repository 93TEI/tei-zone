package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.Dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.Dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.Dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    // @Autowired로 bean을 주입받지 않고 이 어노테이션으로 final 필드를 포함한 생성자 생성을 통해 bean을 받음
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 등록 기능
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //수정기능
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) //@RequestBody를 통해 JSON형태의 데이터를 PostsUpdateRequestDto형태로 바꿔줌
    {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // 조회기능
    public PostsResponseDto findById (@PathVariable Long id)
    {

        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}") // 삭제
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
