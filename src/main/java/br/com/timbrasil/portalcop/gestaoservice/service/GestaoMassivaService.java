package br.com.timbrasil.portalcop.gestaoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaRepository;

@Service
public class GestaoMassivaService {
  @Autowired
  MassivaRepository massivaRepository;

  public List<MassivaDto> getMassiva() {
    Optional<List<Optional<MassivaDto>>> massivasMetalico = massivaRepository.findByStatus(0);
    if(massivasMetalico.isPresent()) {
      List<MassivaDto> massivasMeataliDtos = massivasMetalico.get().stream().map(m -> m.get()).toList();
      return massivasMeataliDtos;
    }
    return List.of();
  }
}
