package net.programmingpointer.journalapp.repository;

import net.programmingpointer.journalapp.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry,String> {
}
