package edu.practice.databaseconnection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: person.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "PersonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.practice.databaseconnection.PersonRequest,
      edu.practice.databaseconnection.PersonResponse> getCreatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePerson",
      requestType = edu.practice.databaseconnection.PersonRequest.class,
      responseType = edu.practice.databaseconnection.PersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.practice.databaseconnection.PersonRequest,
      edu.practice.databaseconnection.PersonResponse> getCreatePersonMethod() {
    io.grpc.MethodDescriptor<edu.practice.databaseconnection.PersonRequest, edu.practice.databaseconnection.PersonResponse> getCreatePersonMethod;
    if ((getCreatePersonMethod = PersonServiceGrpc.getCreatePersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getCreatePersonMethod = PersonServiceGrpc.getCreatePersonMethod) == null) {
          PersonServiceGrpc.getCreatePersonMethod = getCreatePersonMethod =
              io.grpc.MethodDescriptor.<edu.practice.databaseconnection.PersonRequest, edu.practice.databaseconnection.PersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.PersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.PersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("CreatePerson"))
              .build();
        }
      }
    }
    return getCreatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.practice.databaseconnection.GetPersonRequest,
      edu.practice.databaseconnection.PersonResponse> getGetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPerson",
      requestType = edu.practice.databaseconnection.GetPersonRequest.class,
      responseType = edu.practice.databaseconnection.PersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.practice.databaseconnection.GetPersonRequest,
      edu.practice.databaseconnection.PersonResponse> getGetPersonMethod() {
    io.grpc.MethodDescriptor<edu.practice.databaseconnection.GetPersonRequest, edu.practice.databaseconnection.PersonResponse> getGetPersonMethod;
    if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
          PersonServiceGrpc.getGetPersonMethod = getGetPersonMethod =
              io.grpc.MethodDescriptor.<edu.practice.databaseconnection.GetPersonRequest, edu.practice.databaseconnection.PersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.GetPersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.PersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetPerson"))
              .build();
        }
      }
    }
    return getGetPersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.practice.databaseconnection.Empty,
      edu.practice.databaseconnection.PersonListResponse> getGetAllPersonsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPersons",
      requestType = edu.practice.databaseconnection.Empty.class,
      responseType = edu.practice.databaseconnection.PersonListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.practice.databaseconnection.Empty,
      edu.practice.databaseconnection.PersonListResponse> getGetAllPersonsMethod() {
    io.grpc.MethodDescriptor<edu.practice.databaseconnection.Empty, edu.practice.databaseconnection.PersonListResponse> getGetAllPersonsMethod;
    if ((getGetAllPersonsMethod = PersonServiceGrpc.getGetAllPersonsMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetAllPersonsMethod = PersonServiceGrpc.getGetAllPersonsMethod) == null) {
          PersonServiceGrpc.getGetAllPersonsMethod = getGetAllPersonsMethod =
              io.grpc.MethodDescriptor.<edu.practice.databaseconnection.Empty, edu.practice.databaseconnection.PersonListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPersons"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.PersonListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetAllPersons"))
              .build();
        }
      }
    }
    return getGetAllPersonsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.practice.databaseconnection.UpdatePersonRequest,
      edu.practice.databaseconnection.PersonResponse> getUpdatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePerson",
      requestType = edu.practice.databaseconnection.UpdatePersonRequest.class,
      responseType = edu.practice.databaseconnection.PersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.practice.databaseconnection.UpdatePersonRequest,
      edu.practice.databaseconnection.PersonResponse> getUpdatePersonMethod() {
    io.grpc.MethodDescriptor<edu.practice.databaseconnection.UpdatePersonRequest, edu.practice.databaseconnection.PersonResponse> getUpdatePersonMethod;
    if ((getUpdatePersonMethod = PersonServiceGrpc.getUpdatePersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getUpdatePersonMethod = PersonServiceGrpc.getUpdatePersonMethod) == null) {
          PersonServiceGrpc.getUpdatePersonMethod = getUpdatePersonMethod =
              io.grpc.MethodDescriptor.<edu.practice.databaseconnection.UpdatePersonRequest, edu.practice.databaseconnection.PersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.UpdatePersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.PersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("UpdatePerson"))
              .build();
        }
      }
    }
    return getUpdatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.practice.databaseconnection.DeletePersonRequest,
      edu.practice.databaseconnection.DeleteResponse> getDeletePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePerson",
      requestType = edu.practice.databaseconnection.DeletePersonRequest.class,
      responseType = edu.practice.databaseconnection.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.practice.databaseconnection.DeletePersonRequest,
      edu.practice.databaseconnection.DeleteResponse> getDeletePersonMethod() {
    io.grpc.MethodDescriptor<edu.practice.databaseconnection.DeletePersonRequest, edu.practice.databaseconnection.DeleteResponse> getDeletePersonMethod;
    if ((getDeletePersonMethod = PersonServiceGrpc.getDeletePersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getDeletePersonMethod = PersonServiceGrpc.getDeletePersonMethod) == null) {
          PersonServiceGrpc.getDeletePersonMethod = getDeletePersonMethod =
              io.grpc.MethodDescriptor.<edu.practice.databaseconnection.DeletePersonRequest, edu.practice.databaseconnection.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.DeletePersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.practice.databaseconnection.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("DeletePerson"))
              .build();
        }
      }
    }
    return getDeletePersonMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonServiceStub>() {
        @java.lang.Override
        public PersonServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonServiceStub(channel, callOptions);
        }
      };
    return PersonServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonServiceBlockingStub>() {
        @java.lang.Override
        public PersonServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonServiceBlockingStub(channel, callOptions);
        }
      };
    return PersonServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonServiceFutureStub>() {
        @java.lang.Override
        public PersonServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonServiceFutureStub(channel, callOptions);
        }
      };
    return PersonServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createPerson(edu.practice.databaseconnection.PersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePersonMethod(), responseObserver);
    }

    /**
     */
    default void getPerson(edu.practice.databaseconnection.GetPersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPersonMethod(), responseObserver);
    }

    /**
     */
    default void getAllPersons(edu.practice.databaseconnection.Empty request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPersonsMethod(), responseObserver);
    }

    /**
     */
    default void updatePerson(edu.practice.databaseconnection.UpdatePersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePersonMethod(), responseObserver);
    }

    /**
     */
    default void deletePerson(edu.practice.databaseconnection.DeletePersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePersonMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PersonService.
   */
  public static abstract class PersonServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PersonServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PersonService.
   */
  public static final class PersonServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PersonServiceStub> {
    private PersonServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPerson(edu.practice.databaseconnection.PersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPerson(edu.practice.databaseconnection.GetPersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPersons(edu.practice.databaseconnection.Empty request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPersonsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePerson(edu.practice.databaseconnection.UpdatePersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePerson(edu.practice.databaseconnection.DeletePersonRequest request,
        io.grpc.stub.StreamObserver<edu.practice.databaseconnection.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePersonMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PersonService.
   */
  public static final class PersonServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.practice.databaseconnection.PersonResponse createPerson(edu.practice.databaseconnection.PersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.practice.databaseconnection.PersonResponse getPerson(edu.practice.databaseconnection.GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.practice.databaseconnection.PersonListResponse getAllPersons(edu.practice.databaseconnection.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPersonsMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.practice.databaseconnection.PersonResponse updatePerson(edu.practice.databaseconnection.UpdatePersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.practice.databaseconnection.DeleteResponse deletePerson(edu.practice.databaseconnection.DeletePersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePersonMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PersonService.
   */
  public static final class PersonServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.practice.databaseconnection.PersonResponse> createPerson(
        edu.practice.databaseconnection.PersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.practice.databaseconnection.PersonResponse> getPerson(
        edu.practice.databaseconnection.GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.practice.databaseconnection.PersonListResponse> getAllPersons(
        edu.practice.databaseconnection.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPersonsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.practice.databaseconnection.PersonResponse> updatePerson(
        edu.practice.databaseconnection.UpdatePersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.practice.databaseconnection.DeleteResponse> deletePerson(
        edu.practice.databaseconnection.DeletePersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePersonMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERSON = 0;
  private static final int METHODID_GET_PERSON = 1;
  private static final int METHODID_GET_ALL_PERSONS = 2;
  private static final int METHODID_UPDATE_PERSON = 3;
  private static final int METHODID_DELETE_PERSON = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PERSON:
          serviceImpl.createPerson((edu.practice.databaseconnection.PersonRequest) request,
              (io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse>) responseObserver);
          break;
        case METHODID_GET_PERSON:
          serviceImpl.getPerson((edu.practice.databaseconnection.GetPersonRequest) request,
              (io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_PERSONS:
          serviceImpl.getAllPersons((edu.practice.databaseconnection.Empty) request,
              (io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PERSON:
          serviceImpl.updatePerson((edu.practice.databaseconnection.UpdatePersonRequest) request,
              (io.grpc.stub.StreamObserver<edu.practice.databaseconnection.PersonResponse>) responseObserver);
          break;
        case METHODID_DELETE_PERSON:
          serviceImpl.deletePerson((edu.practice.databaseconnection.DeletePersonRequest) request,
              (io.grpc.stub.StreamObserver<edu.practice.databaseconnection.DeleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreatePersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.practice.databaseconnection.PersonRequest,
              edu.practice.databaseconnection.PersonResponse>(
                service, METHODID_CREATE_PERSON)))
        .addMethod(
          getGetPersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.practice.databaseconnection.GetPersonRequest,
              edu.practice.databaseconnection.PersonResponse>(
                service, METHODID_GET_PERSON)))
        .addMethod(
          getGetAllPersonsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.practice.databaseconnection.Empty,
              edu.practice.databaseconnection.PersonListResponse>(
                service, METHODID_GET_ALL_PERSONS)))
        .addMethod(
          getUpdatePersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.practice.databaseconnection.UpdatePersonRequest,
              edu.practice.databaseconnection.PersonResponse>(
                service, METHODID_UPDATE_PERSON)))
        .addMethod(
          getDeletePersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.practice.databaseconnection.DeletePersonRequest,
              edu.practice.databaseconnection.DeleteResponse>(
                service, METHODID_DELETE_PERSON)))
        .build();
  }

  private static abstract class PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.practice.databaseconnection.PersonProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonService");
    }
  }

  private static final class PersonServiceFileDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier {
    PersonServiceFileDescriptorSupplier() {}
  }

  private static final class PersonServiceMethodDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PersonServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonServiceFileDescriptorSupplier())
              .addMethod(getCreatePersonMethod())
              .addMethod(getGetPersonMethod())
              .addMethod(getGetAllPersonsMethod())
              .addMethod(getUpdatePersonMethod())
              .addMethod(getDeletePersonMethod())
              .build();
        }
      }
    }
    return result;
  }
}
