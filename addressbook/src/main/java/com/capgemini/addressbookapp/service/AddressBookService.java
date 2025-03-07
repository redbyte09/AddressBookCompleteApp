package com.capgemini.addressbookapp.service;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import com.capgemini.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);  // To generate unique IDs

    // Create a new entry (DTO -> Entity)
    public AddressBook saveEntry(AddressBookDTO dto) {
        AddressBook newEntry = new AddressBook(idCounter.getAndIncrement(), dto);
        addressBookList.add(newEntry);
        return newEntry;
    }

    // Retrieve all entries
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    // Retrieve entry by ID
    public Optional<AddressBook> getEntryById(Long id) {
        return addressBookList.stream().filter(entry -> entry.getId().equals(id)).findFirst();
    }

    // Update an existing entry
    public Optional<AddressBook> updateEntry(Long id, AddressBookDTO newEntry) {
        return getEntryById(id).map(entry -> {
            entry.setName(newEntry.getName());
            entry.setPhoneNumber(newEntry.getPhoneNumber());
            entry.setEmail(newEntry.getEmail());
            entry.setAddress(newEntry.getAddress());
            return entry;
        });
    }

    // Delete an entry by ID
    public boolean deleteEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}