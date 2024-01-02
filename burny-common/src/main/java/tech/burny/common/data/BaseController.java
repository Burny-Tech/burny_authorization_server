package tech.burny.common.data;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
public class BaseController<T> {
    private BaseService<T> baseService;

    @PostMapping
    public  T create(T t){
        return baseService.create(t);
    }
    @PutMapping
    public  T update(T t){
        return baseService.update(t);
    }
    @GetMapping
    public Page<T> page(Pageable pageable){
        return baseService.page(pageable);
    }

    @DeleteMapping
    public void del(Long id){
        baseService.del(id);
    }

}
