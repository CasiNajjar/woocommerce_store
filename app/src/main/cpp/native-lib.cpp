#include <jni.h>
extern "C" {
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_NextInnovation_invokeConsumerKey(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("Y2tfZThlNjhmOGFkYmUzZjRiZGE2YThlNDQ5MmQwZjRlNGY4ZWMzOTc2MA==");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_NextInnovation_invokeConsumerSecret(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("Y3NfNDAyMzg3NDhjMDE0YzdmOWNlM2MxYTg0MDI0NGI3MTM3ZThhOTU2Mg==");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_AppBaseUrl_invokeBaseUrl(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("aHR0cDovL2RlbW8ubmV4dC1pbm5vdmF0aW9uLmNvLmlkL3N0b3JlLw==");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_ApiUrl_invokeAuthUrl(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("YXBpL3VzZXIvZ2VuZXJhdGVfYXV0aF9jb29raWU=");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_ApiUrl_invokeRegistUrl(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("d3AtanNvbi93Yy92Mi9jdXN0b21lcnM=");
}
}
