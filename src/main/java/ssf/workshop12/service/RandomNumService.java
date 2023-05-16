package ssf.workshop12.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RandomNumService {
    
    public List<Integer> generateRanNumbers(int number){
        //returns a random number
        return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList());
    
    }
}
