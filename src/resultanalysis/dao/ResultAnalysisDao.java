package resultanalysis.dao;

import java.io.File;
import java.util.ArrayList;

import resultanalysis.domain.Result;

public interface ResultAnalysisDao {
	abstract ArrayList<File> getFilePath();
	abstract ArrayList<File> getJsonPath();
	abstract ArrayList<File> getLogPath();
}
