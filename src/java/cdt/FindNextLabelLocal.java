/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdt;

import javax.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface FindNextLabelLocal {
    
    /**
     *
     * @param current
     * @param next
     * @return
     */
    public Object findNext(float current,float next);
    
}
