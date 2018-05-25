/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;


public interface Mapper <T,S>{ // Uwaga: interfejs musi być sparametrtyzowany
	S map(T arg);
}  
