package com.utfpr.todo.tasks;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskModel, String> {
        
}
