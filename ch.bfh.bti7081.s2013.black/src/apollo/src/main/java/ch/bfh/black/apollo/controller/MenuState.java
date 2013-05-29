package ch.bfh.black.apollo.controller;

/**
 * Interface for all Menu States.
 * Every State can be initalized (init) and closed (back).
 * 
 * @author vill
 */
public interface MenuState {
    
    public void init();
    public void back();
}
