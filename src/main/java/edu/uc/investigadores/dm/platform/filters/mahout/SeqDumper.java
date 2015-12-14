/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform.filters.mahout;

import edu.uc.investigadores.dm.platform.mahout.Mahout;
import edu.uc.investigadores.dm.platform.filters.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.utils.SequenceFileDumper;
import org.apache.mahout.utils.vectors.VectorDumper;

/**
 *
 * @author cuent
 */
public class SeqDumper extends Mahout implements Filter{

    @Override
    public void build() {
        try {
            SequenceFileDumper.main(this.getConfiguration().getOptions());
        } catch (Exception ex) {
            Logger.getLogger(SeqDumper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
