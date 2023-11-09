package med.voll.api.domain.consulta;

import med.voll.api.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Consulta c WHERE c.paciente.id = :idPaciente AND c.data BETWEEN :primeiroHorario AND :ultimoHorario")
    boolean existsByPacienteIdAndDataBetween(@Param("idPaciente") Long idPaciente, @Param("primeiroHorario") LocalDateTime primeiroHorario, @Param("ultimoHorario") LocalDateTime ultimoHorario);

    Boolean existByMedicoIdAndData(Long idMedico, LocalDateTime data);
}
