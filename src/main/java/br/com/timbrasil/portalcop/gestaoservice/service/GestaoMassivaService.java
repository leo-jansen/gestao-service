package br.com.timbrasil.portalcop.gestaoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalica;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaMetalicaRepository;

@Service
public class GestaoMassivaService {
  @Autowired
  MassivaMetalicaRepository massivaMetalicaRepository;

  public List<MassivaDto> getMassiva() {
    List<MassivaMetalica> massivasMetalica = massivaMetalicaRepository.findAll();
    List<MassivaDto> massivasMetalicasDto = MassivaDto.converter(massivasMetalica);
    return massivasMetalicasDto;
   
  }
}
