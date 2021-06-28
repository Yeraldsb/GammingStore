package gammingStore.services;


import gammingStore.models.Etiqueta;
import gammingStore.models.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private EtiquetaRepository etiquetaRepository;

    @Autowired
    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Etiqueta> allEtiquetas() {
        return (List<Etiqueta>) etiquetaRepository.findAll();
    }
}
