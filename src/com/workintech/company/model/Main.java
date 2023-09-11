package com.workintech.company.model;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Java Collection", "Write List", "Ann",
                Priority.LOW, Status.ASSIGNED);
        Task task2 = new Task("Java Collection", "Write Set", "Bob",
                Priority.LOW, Status.ASSIGNED);
        Task task3 = new Task("Java Collection", "Write LinkedList", "Carol",
                Priority.LOW, Status.ASSIGNED);
        Task task4 = new Task("Java Collection", "Write Map", "Bob",
                Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collection", "Write ArrayList", "Ann",
                Priority.LOW, Status.ASSIGNED);
        Task task6 = new Task("Java Collection", "Write List in Set ", "",
                Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("Java Collection", "Write ArrayList ", "Bob",
                Priority.MED, Status.IN_QUEUE);

        Set<Task>totalTasks=new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);


        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task5);

        Set<Task>bobsTask=new LinkedHashSet<>();
        bobsTask.add(task2);
        bobsTask.add(task4);

        Set<Task>carolsTask=new LinkedHashSet<>();
        bobsTask.add(task3);

        Set<Task>unassignedTasks= new HashSet<>();
        unassignedTasks.add(task6);

        TaskData taskData=new TaskData(annsTask,bobsTask,carolsTask,unassignedTasks);
//List<Set<Task>> tasks=new ArrayList<>();
//tasks.add(annsTask);
//tasks.add(bobsTask);
//tasks.add(carolsTask);
        //taskData.getUnion(tasks);

        //Get all tasks
        System.out.println("All tasks:");
        System.out.println(taskData.getTasks("all"));
        System.out.println("***************");

        System.out.println("Ann's tasks");
        System.out.println(taskData.getTasks("ann"));
        System.out.println("***************");

        System.out.println("Bob's tasks");
        System.out.println(taskData.getTasks("bob"));
        System.out.println("***************");

        System.out.println("Carol's tasks");
        System.out.println(taskData.getTasks("carol"));
        System.out.println("***************");

        //Ataması yapılmamış tasklar
        System.out.println(taskData.getDifference(totalTasks,taskData.getTasks("all")));
        System.out.println("*******************");
    //Birden fazla ataması yapılmış
        System.out.println("Ann+Carol:"+taskData.getIntersection(annsTask,carolsTask));
        System.out.println("Bob+Carol:"+taskData.getIntersection(bobsTask,carolsTask));
        System.out.println("Ann+Bob:"+taskData.getIntersection(annsTask,bobsTask));

    }


}
