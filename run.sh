# Other Model
cat <<EOF > src/main/java/com/smartonion/salt/model/Inventory/Other.java
package com.smartonion.salt.model.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "others")
public class Other extends InventoryItem {
    private String specialAttribute; // Additional attribute specific to Other
}
EOF

# Other Repository
cat <<EOF > src/main/java/com/smartonion/salt/repository/Inventory/OtherRepository.java
package com.smartonion.salt.repository.Inventory;

import com.smartonion.salt.model.Inventory.Other;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OtherRepository extends MongoRepository<Other, String> {
    // Custom queries can be defined here if needed
}
EOF

# Other Service
cat <<EOF > src/main/java/com/smartonion/salt/service/Inventory/OtherService.java
package com.smartonion.salt.service.Inventory;

import com.smartonion.salt.model.Inventory.Other;
import com.smartonion.salt.repository.Inventory.OtherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OtherService {

    @Autowired
    private OtherRepository otherRepository;

    public Other getOtherById(String id) {
        return otherRepository.findById(id).orElse(null);
    }

    public Other createOther(Other other) {
        other.setItemId(UUID.randomUUID().toString().split("-")[0]);
        return otherRepository.save(other);
    }

    public List<Other> getAllOthers() {
        return otherRepository.findAll();
    }

    public Other updateOther(String id, Other other) {
        return otherRepository.existsById(id) ? otherRepository.save(other) : null;
    }

    public boolean deleteOther(String id) {
        if (otherRepository.existsById(id)) {
            otherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
EOF

echo "Other MVC files created successfully."