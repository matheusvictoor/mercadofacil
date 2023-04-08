package com.ufcg.psoft.mercadofacil.repository;

import java.util.*;
import com.ufcg.psoft.mercadofacil.model.Lote;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LoteVolatilRepository{
    List<Lote> lotes = new ArrayList<>();


    public Lote save(Lote lote) {
        lotes.add(lote);
        return lotes.get(lotes.size()-1);
    }


    public Lote find(Long id) {
        int index = id.intValue() - 1;
        if(index >= 0 && index < lotes.size())
            return lotes.get(index);
       throw new IndexOutOfBoundsException("O elemento não existe na lista de lotes.");
    }


    public List<Lote> findAll() {

        return lotes;
    }

    public Lote update(Lote lote) {
        lotes.clear();
        lotes.add(lote);
        return lotes.stream().findFirst().orElse(null);
    }


    public void delete(Lote lote) {
        lotes.remove(lote);
    }


    public void deleteAll() {
        lotes.clear();
    }
}
