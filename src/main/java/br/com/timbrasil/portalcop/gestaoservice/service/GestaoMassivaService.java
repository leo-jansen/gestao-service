package br.com.timbrasil.portalcop.gestaoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.repository.MassivaRepository;

@Service
public class GestaoMassivaService {
  @Autowired
  MassivaRepository massivaRepository;

  public List<MassivaDto> getMassiva() {
    
    return null;
  }
}
