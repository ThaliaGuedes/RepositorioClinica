package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    // vai trazer todos os medicos, ordenar aleatoriamente e trazer apenas o primeiro registro
    @Query(nativeQuery = true, value = "SELECT * FROM Medico m " +
            "WHERE m.ativo = true " +
            "AND m.especialidade = :especialidade " +
            "AND m.id NOT IN (" +
            "    SELECT c.medico_id FROM Consulta c " +
            "    WHERE c.data = :data" +
            ") " +
            "ORDER BY random() " +
            "LIMIT 1")
    Medico escolherMedicoAleatorioLivreNaData(@Param("especialidade") Especialidade especialidade, @Param("data") LocalDateTime data);



    @Query("SELECT ativo FROM Medico WHERE id = :id")
    Boolean findAtivoById(@Param("id") Long id);

}
