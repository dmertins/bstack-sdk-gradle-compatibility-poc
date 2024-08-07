# bstack-sdk-gradle-compatibility-poc
Project to reproduce BrowserStack SDK error when running tests on more than one device with Gradle.

## Project Requirements
- JDK ≥ 17.0.2

## Steps to reproduce the error
```shell
$ ./gradlew clean bstackTest --stacktrace
```

Expected error:
```
$ ./gradlew clean bstackTest --stacktrace
java.io.EOFException
        at java.base/java.io.DataInputStream.readFully(DataInputStream.java:210)
        at java.base/java.io.DataInputStream.readInt(DataInputStream.java:385)
        at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:38)
        at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java)
java.io.EOFException
        at java.base/java.io.DataInputStream.readFully(DataInputStream.java:210)
        at java.base/java.io.DataInputStream.readInt(DataInputStream.java:385)
        at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:38)
        at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java)
[INFO] View build on BrowserStack dashboard: https://app-automate.browserstack.com/dashboard/v2/builds/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
> Task :bstackTest FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':bstackTest'.
> Process 'Gradle Test Executor 21' finished with non-zero exit value 1
  This problem might be caused by incorrect test process configuration.
  For more on test execution, please refer to https://docs.gradle.org/8.5/userguide/java_testing.html#sec:test_execution in the Gradle documentation.

* Try:
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

* Exception is:
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':bstackTest'.
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:148)
        at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:282)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:146)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:134)
        at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
        at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
        at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
        at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:74)
        at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
        at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:42)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:331)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:318)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.lambda$execute$0(DefaultTaskExecutionGraph.java:314)
        at org.gradle.internal.operations.CurrentBuildOperationRef.with(CurrentBuildOperationRef.java:80)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:314)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:303)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:463)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:380)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
Caused by: org.gradle.process.internal.ExecException: Process 'Gradle Test Executor 21' finished with non-zero exit value 1
This problem might be caused by incorrect test process configuration.
For more on test execution, please refer to https://docs.gradle.org/8.5/userguide/java_testing.html#sec:test_execution in the Gradle documentation.
        at org.gradle.api.internal.tasks.testing.worker.ForkingTestClassProcessor.stop(ForkingTestClassProcessor.java:159)
        at org.gradle.api.internal.tasks.testing.processors.RestartEveryNTestClassProcessor.endBatch(RestartEveryNTestClassProcessor.java:77)
        at org.gradle.api.internal.tasks.testing.processors.RestartEveryNTestClassProcessor.stop(RestartEveryNTestClassProcessor.java:62)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
        at org.gradle.internal.dispatch.FailureHandlingDispatch.dispatch(FailureHandlingDispatch.java:30)
        at org.gradle.internal.dispatch.AsyncDispatch.dispatchMessages(AsyncDispatch.java:87)
        at org.gradle.internal.dispatch.AsyncDispatch.access$000(AsyncDispatch.java:36)
        at org.gradle.internal.dispatch.AsyncDispatch$1.run(AsyncDispatch.java:71)
        at org.gradle.internal.concurrent.InterruptibleRunnable.run(InterruptibleRunnable.java:42)
        at org.gradle.internal.operations.CurrentBuildOperationRef.with(CurrentBuildOperationRef.java:80)
        at org.gradle.internal.operations.CurrentBuildOperationPreservingRunnable.run(CurrentBuildOperationPreservingRunnable.java:51)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)


BUILD FAILED in 1m 16s
3 actionable tasks: 3 executed
```
