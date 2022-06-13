package com.example.quasar.protobuf;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.1.1)",
    comments = "Source: src/main/proto/Test.proto")
public class SessionGrpc {

  private SessionGrpc() {}

  public static final String SERVICE_NAME = "YallaDomino.Session";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.quasar.protobuf.TestWH.Test,
      com.example.quasar.protobuf.TestWH.Rep> METHOD_MSG_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "YallaDomino.Session", "MsgAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.example.quasar.protobuf.TestWH.Test.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.example.quasar.protobuf.TestWH.Rep.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SessionStub newStub(io.grpc.Channel channel) {
    return new SessionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SessionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SessionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SessionFutureStub(channel);
  }

  /**
   */
  public static abstract class SessionImplBase implements io.grpc.BindableService {

    /**
     */
    public void msgAdd(com.example.quasar.protobuf.TestWH.Test request,
        io.grpc.stub.StreamObserver<com.example.quasar.protobuf.TestWH.Rep> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MSG_ADD, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_MSG_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.quasar.protobuf.TestWH.Test,
                com.example.quasar.protobuf.TestWH.Rep>(
                  this, METHODID_MSG_ADD)))
          .build();
    }
  }

  /**
   */
  public static final class SessionStub extends io.grpc.stub.AbstractStub<SessionStub> {
    private SessionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionStub(channel, callOptions);
    }

    /**
     */
    public void msgAdd(com.example.quasar.protobuf.TestWH.Test request,
        io.grpc.stub.StreamObserver<com.example.quasar.protobuf.TestWH.Rep> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MSG_ADD, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SessionBlockingStub extends io.grpc.stub.AbstractStub<SessionBlockingStub> {
    private SessionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.quasar.protobuf.TestWH.Rep msgAdd(com.example.quasar.protobuf.TestWH.Test request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MSG_ADD, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SessionFutureStub extends io.grpc.stub.AbstractStub<SessionFutureStub> {
    private SessionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.quasar.protobuf.TestWH.Rep> msgAdd(
        com.example.quasar.protobuf.TestWH.Test request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MSG_ADD, getCallOptions()), request);
    }
  }

  private static final int METHODID_MSG_ADD = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SessionImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(SessionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MSG_ADD:
          serviceImpl.msgAdd((com.example.quasar.protobuf.TestWH.Test) request,
              (io.grpc.stub.StreamObserver<com.example.quasar.protobuf.TestWH.Rep>) responseObserver);
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

  private static final class SessionDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.quasar.protobuf.TestWH.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SessionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SessionDescriptorSupplier())
              .addMethod(METHOD_MSG_ADD)
              .build();
        }
      }
    }
    return result;
  }
}
