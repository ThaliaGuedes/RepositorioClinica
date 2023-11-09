package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalTime.now();
        var diferencaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();
        if (diferencaEmMinutos < 30){
            throw new ValidationException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }
    }

}
