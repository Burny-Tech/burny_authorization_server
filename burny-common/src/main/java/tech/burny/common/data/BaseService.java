package tech.burny.common.data;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class BaseService<T> {


    private  BaseRepository<T> baseRepository;

    public  T create(T t){
        return baseRepository.save(t);
    }
    public  T update(T t){
        return baseRepository.save(t);
    }
    public Page<T> page(Pageable pageable){
        return baseRepository.findAll(pageable);
    }

    public void del(Long id){
         baseRepository.deleteById(id);
    }
}
