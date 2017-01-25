/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryan.business;

/**
 *
 * @author 1333612
 */
public class LoanCalculator {
    
    public LoanCalculator(){
        
    }
    
    public double calculate(double pv, double rate, int n){
        double pmt = 0.0;
        rate = rate/12/100;
        if(n>0){
            n = n*-1;
        }
        
        pmt = (pv*rate)/(1-(Math.pow((1+rate),n)));
        return pmt;
    }
}
