package gammingStore.services;


import gammingStore.models.PEGIcontent;
import gammingStore.models.PEGIcontentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PEGIcontentService {

    private PEGIcontentRepository pegIcontentRepository;

    @Autowired
    public PEGIcontentService(PEGIcontentRepository pegIcontentRepository) {
        this.pegIcontentRepository = pegIcontentRepository;
    }

    public List<PEGIcontent> allPEGIcontents() {
        return (List<PEGIcontent>) pegIcontentRepository.findAll();
    }
}
