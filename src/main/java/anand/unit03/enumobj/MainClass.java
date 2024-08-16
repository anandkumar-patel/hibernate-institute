package anand.unit03.enumobj;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();
        Project project = new Project();
        project.setProjectName("TPO");
        project.setProjectStatus(ProjectStatus.INPROGESS);
        projectDao.saveProject(project);

        List < Project > projects = projectDao.getProjects();
        projects.forEach(s -> {
            System.out.println(s.getProjectName());
            System.out.println(s.getProjectStatus());
        });
	}

}
