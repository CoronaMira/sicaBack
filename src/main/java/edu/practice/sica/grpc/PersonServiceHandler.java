package edu.practice.sica.grpc;


import edu.practice.sica.*;
import edu.practice.sica.entity.Person;
import edu.practice.sica.service.PersonService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.stream.Collectors;

@GrpcService
public class PersonServiceHandler extends PersonServiceGrpc.PersonServiceImplBase  {

    private final PersonService personService ;

    public PersonServiceHandler(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void createPerson(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        Person person = mapToEntity(request);
        Person saved = personService.create(person);
        responseObserver.onNext(mapToResponse(saved));
        responseObserver.onCompleted();
    }

    public void getPerson(GetPersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        personService.findById(request.getId())
                .map(this::mapToResponse)
                .ifPresentOrElse(
                        responseObserver::onNext,
                        () -> responseObserver.onError(new RuntimeException("Person not found with id: " + request.getId()))
                );
        responseObserver.onCompleted();
    }

    @Override
    public void getAllPersons(Empty request, StreamObserver<PersonListResponse> responseObserver) {
        var list = personService.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        PersonListResponse response = PersonListResponse.newBuilder()
                .addAllPersons(list)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updatePerson(UpdatePersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        Person updated = personService.update(request.getId(), mapToEntity(request.getPerson()));
        responseObserver.onNext(mapToResponse(updated));
        responseObserver.onCompleted();
    }

    @Override
    public void deletePerson(DeletePersonRequest request, StreamObserver<DeleteResponse> responseObserver) {
        personService.deleteById(request.getId());
        DeleteResponse response = DeleteResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private Person mapToEntity(PersonRequest request) {
        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setMiddleName(request.getMiddleName());
        person.setType(request.getType());
        person.setEnrollment(request.getEnrollment());
        person.setDegree(request.getDegree());
        person.setShift(request.getShift());
        return person;
    }

    private PersonResponse mapToResponse(Person person) {
        return PersonResponse.newBuilder()
                .setId(person.getId())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setMiddleName(person.getMiddleName())
                .setType(person.getType())
                .setEnrollment(person.getEnrollment())
                .setDegree(person.getDegree())
                .setShift(person.getShift())
                .build();
    }
}
