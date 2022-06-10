package br.com.timbrasil.portalcop.gestaoservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.gestaoservice.form.MassivaMetalicaForm;
import br.com.timbrasil.portalcop.gestaoservice.model.Massiva;
import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalServiceId;
import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalica;
import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalicaMsg;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaMetalServiceIdRepository;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaMetalicaMsgRepository;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaMetalicaRepository;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GestaoMassivaService {
  @Autowired
  MassivaMetalicaRepository massivaMetalicaRepository;

  @Autowired
  MassivaRepository massivaRepository;

  @Autowired
  MassivaMetalicaMsgRepository massivaMetalicaMsgRepository;

  @Autowired
  MassivaMetalServiceIdRepository massivaMetalServiceIdRepository;

  public List<MassivaMetalicaDto> getMassiva() {
    List<MassivaMetalica> massivasMetalica = massivaMetalicaRepository.findAll();
    List<MassivaMetalicaDto> massivasMetalicasDto = MassivaMetalicaDto.converter(massivasMetalica);
    return massivasMetalicasDto;

  }

  @Transactional
  public MassivaMetalicaDto cadastroMassivaMetalica(MassivaMetalicaForm massivaMetalica, String matricula) {
    if (massivaMetalica.getIdAcao() == 1) {
      log.info("Cadastrando massiva metalica RMT: " + massivaMetalica.getIdMassiva());
      Long quantidade = massivaRepository.findByParInicioAndParFimAndMsan(massivaMetalica.getParInicio(),
          massivaMetalica.getParFim(), massivaMetalica.getMsan());
      if (quantidade > 0) {
        log.info("Massiva metalica RMT: " + massivaMetalica.getIdMassiva()
            + "já cadastrada para Msan:" + massivaMetalica.getMsan()
            + ", de Inicio: " + massivaMetalica.getParInicio()
            + " e Fim: " + massivaMetalica.getParFim());
        return null;
      }
    }
    Massiva massiva = new Massiva();
    massiva = massivaRepository.save(massiva);
    String idMassiva = "";
    switch (massivaMetalica.getIdAcao()) {
      case 1:
        log.trace("Montando Id massiva para RMT");
        idMassiva = "RMT_" + massiva.getId();
        break;
      case 2:
        log.trace("Montando Id massiva para MPP");
        idMassiva = "MPP_" + massiva.getId();
        break;
      case 3:
        log.trace("Montando Id massiva para MPS");
        idMassiva = "MPS_" + massiva.getId();
        break;
      default:
        log.trace("Montando Id massiva para RMT");
        idMassiva = "RMT_" + massiva.getId();
        break;
    }
    massiva.setIdMassiva(idMassiva);
    massivaRepository.save(massiva);
    
    registrarMsgMassivaMetalica(idMassiva, matricula, "Incluir");

    atualizarMassivaMetalica(massiva.getId(), massivaMetalica.getEmpreiteira(), massivaMetalica.getObservacao(), matricula,
        massivaMetalica.getParInicio(), massivaMetalica.getParFim(), massivaMetalica.getMsan(),
        massivaMetalica.getIdAcao(), false);

    return null;
  }

  public void registrarMsgMassivaMetalica(String idMassiva, String matricula, String acao) {
    log.info("Registrando mensagem de massiva metalica: " + idMassiva + " - " + acao);
    MassivaMetalicaMsg massivaMetalicaMsg = new MassivaMetalicaMsg(LocalDateTime.now(), idMassiva, matricula, acao);
    massivaMetalicaMsgRepository.save(massivaMetalicaMsg);
  }

  public void atualizarMassivaMetalica(Long id, String empreiteira, String observacao, String matricula,
      String parInicio, String parFim, String msan, Integer idAcao, Boolean ativo) {
    log.info("Atualizando massiva metalica: " + id);
    atualizarClientesImpactados(msan, parInicio, parFim, idAcao, id);
  }

  public void atualizarClientesImpactados(String msan, String parInicio, String parFim, Integer idAcao, Long id) {
    log.info("Atualizando clientes impactados: " + msan + " - " + parInicio + " - " + parFim + " - " + idAcao + " - " + id);
    Optional<MassivaMetalServiceId> MetalMassivaServiceid = massivaMetalServiceIdRepository.findByFkMetalMassiva(id.toString());
    if(MetalMassivaServiceid.isPresent()) {
      log.info("Excluindo MassivametalServiceId: " + MetalMassivaServiceid.get().getId());
      massivaMetalServiceIdRepository.delete(MetalMassivaServiceid.get());
    }


  }
}
