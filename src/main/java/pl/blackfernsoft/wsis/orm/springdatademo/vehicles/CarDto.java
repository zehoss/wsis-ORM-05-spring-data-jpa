package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CarDto {

    @NotNull
    private String name;

    private Date firstRegistrtion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
