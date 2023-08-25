package com.soundms.musicstorebackend.instrument;

import com.soundms.musicstorebackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    /* Repository layer methods */
    @Autowired
    private InstrumentRepository instRepo;

    /* Services available */


    /*--------------------------------------------------------------------------------------------------------
     * createInst: method that saves an instrument in the DB;
     *
     * @param inst_in - an object containing all the instrument data;
     * * @return - the created and saved instrument in the DB;
     *
      --------------------------------------------------------------------------------------------------------*/
    public Instrument createInst(Instrument inst_in){
        return instRepo.save(inst_in);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getInstById: method that obtains a specific instrument from DB using its id;
     *
     * @param id_inst - the id of the instrument;
     * @return - the instrument data in the DB;
     --------------------------------------------------------------------------------------------------------*/
    public Instrument getInstById(Long id_inst){
        return instRepo.getInstByid(id_inst);
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: method to find all instruments in the DB;
     *
     * @return - a list with all instruments;
     --------------------------------------------------------------------------------------------------------*/
    public List<Instrument> findAll(){
        return instRepo.findAll();
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateInst: method that updates the instrument data given the id;
     *
     * @param instUpdate - the object containing the new data;
     * @return - instrument data updated;
     --------------------------------------------------------------------------------------------------------*/
    public Instrument updateInst(Instrument instUpdate) {
        Instrument present = instRepo.findById(instUpdate.getId()).orElse(null);
        if (present != null) {
            present.setId(instUpdate.getId());
            present.setName(instUpdate.getName());
            present.setPrice(instUpdate.getPrice());
            return instRepo.save(present);
        } else {
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdInst: method that deletes an instrument from the DB;
     *
     * @param id - id from the instrument to be deleted;
     *
     --------------------------------------------------------------------------------------------------------*/
    public void deleteByIdInst(Long id) {
        instRepo.deleteById(id);
    }


}
