# Java

```
Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "./run-kafka-local.sh up"}).waitFor();
Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "./run-kafka-local.sh down"}).waitFor();
```
