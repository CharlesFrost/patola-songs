package online.patologia.libraryrestmongodb.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ServiceResponse<T> {
    private String status;
    private T data;

}
