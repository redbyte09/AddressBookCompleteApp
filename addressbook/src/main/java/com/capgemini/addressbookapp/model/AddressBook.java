package com.capgemini.addressbookapp.model;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Convert DTO to Entity
    public AddressBook(Long id, AddressBookDTO dto) {
        this.id = id;
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
    }
}