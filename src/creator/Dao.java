package creator;

import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;

public interface Dao<T> {
	
	Object get(int id);
	List<T> getAll();
	void save(T t);
	void update(T t, String[] params);
	void delete(T t);
	void saveParseFromRow(CSVRecord csv);
}
