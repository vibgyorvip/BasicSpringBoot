package net.programmingpointer.journalapp.repository;

import net.programmingpointer.journalapp.entity.JournalProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalProfileRepository  extends JpaRepository<JournalProfile,Integer> {
}
