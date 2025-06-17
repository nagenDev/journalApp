package net.engineeringdigest.journlApp.cache;

import jakarta.annotation.PostConstruct;
import net.engineeringdigest.journlApp.entity.ConfigJournalApplEntry;
import net.engineeringdigest.journlApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;
    // This is a simple cache to store application configuration
    // It can be extended to include more complex caching mechanisms if needed
    // For now, it is just a placeholder to demonstrate the concept

    public Map<String,String> APP_CACHE;

    @PostConstruct
    public void init() {
        APP_CACHE = new HashMap<>();
        List<ConfigJournalApplEntry> all = configJournalAppRepository.findAll();
        for(ConfigJournalApplEntry configJournalApplEntry : all) {
            APP_CACHE.put(configJournalApplEntry.getKey(), configJournalApplEntry.getValue());
        }

    }
}
