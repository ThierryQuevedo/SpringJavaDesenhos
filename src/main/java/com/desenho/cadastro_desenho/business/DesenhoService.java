package com.desenho.cadastro_desenho.business;


import com.desenho.cadastro_desenho.infrastrucure.entitys.Desenho;
import com.desenho.cadastro_desenho.infrastrucure.repository.DesenhoRepository;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;

@Service
public class DesenhoService {
    private final DesenhoRepository repository;

    public DesenhoService(DesenhoRepository repository){
        this.repository = repository;
    }
    public void salvarDesenho(Desenho desenho){
        repository.saveAndFlush(desenho);
    }

    public Desenho buscarDesenhoPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarDesenhoPorNome(String nome){
        repository.deleteByNome(nome);
    };

    public void atualizarDesenhoPorId(Integer id, Desenho desenho){
        Desenho desenhoEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Desenho desenhoAtualizado = Desenho.builder()
                .nome(desenho.getNome() != null ? desenho.getNome() : desenhoEntity.getNome())
                .criador(desenho.getCriador() != null ? desenho.getCriador() : desenhoEntity.getCriador())
                .protagonista(desenho.getProtagonista() != null ? desenho.getProtagonista() : desenhoEntity.getProtagonista())
                .ano_lancamento(desenho.getAno_lancamento() != null ? desenho.getAno_lancamento() : desenhoEntity.getAno_lancamento())
                .id(desenhoEntity.getId())
                .build();
        repository.saveAndFlush(desenhoAtualizado);
    }
}
