package com.soundms.musicstorebackend.instrument;

import com.soundms.musicstorebackend.user.User;
import com.soundms.musicstorebackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Instrument/")
public class InstrumentRest {

    /* User service layer methods */
    @Autowired
    private InstrumentService instService;

    /* API endpoints - CRUD operations */

    /*--------------------------------------------------------------------------------------------------------
     * createInst: method that saves an instrument in the DB;
     *
     * @param inst_in - an object containing all the instrument data;
     * * @return - the created and saved instrument in the DB;
     *
      --------------------------------------------------------------------------------------------------------*/
    @PostMapping
    private Instrument createInst(@RequestBody Instrument inst_in){
        return instService.createInst(inst_in);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getAllInst: method to find all instruments in the DB;
     *
     * @return - a list with all instruments;
     --------------------------------------------------------------------------------------------------------*/
    @GetMapping
    private List<Instrument> getAllInst(){
        return instService.findAll();
    }

    /*--------------------------------------------------------------------------------------------------------
      * getInstById: method that obtains a specific instrument from DB using its id;
      *
      * @param id_inst - the id of the instrument;
      * @return - the instrument data in the DB;
      --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/{id}")
    private Instrument getInstById(@PathVariable Long id){
        return instService.getInstById(id);
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateInst: method that updates the instrument data given the id;
     *
     * @param instUpdate - the object containing the new data;
     * @return - instrument data updated;
     --------------------------------------------------------------------------------------------------------*/

    @PutMapping
    private Instrument updateInst(@RequestBody Instrument instUpdate){
        return instService.updateInst(instUpdate);
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteInst: method that deletes an instrument from the DB;
     *
     * @param id - id from the instrument to be deleted;
     *
     --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/{id}")
    private void deleteInst(@PathVariable Long id){
        instService.deleteByIdInst(id);
    }
}
