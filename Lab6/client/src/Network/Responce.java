package Network;

import MainClasses.SpaceMarine;

import java.util.Collection;

public class Responce {

    private String responce;

    private ResponceStatus responceStatus;

    private Collection<SpaceMarine> collection;


    public Responce(String responce, Collection<SpaceMarine> collection){
        this.responce = responce;
        this.collection = collection;
    }

    public Responce(String responce){
        this.responce = responce;
    }

    public Responce(ResponceStatus responceStatus, String responce){
        this.responceStatus = responceStatus;
        this.responce = responce;
    }


    public ResponceStatus getResponceStatus(){
        return this.responceStatus;
    }

    public String getResponce(){
        return this.responce;
    }

    public Collection<SpaceMarine> getCollection(){
        return  this.collection;
    }


}
