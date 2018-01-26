#include <jni.h>
extern "C" {
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_NextInnovation_invokeConsumerKey(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("Y2tfOGQ3NjM4M2E2ODU1ZDI4ODM4YmZiMjU2ZDAxMTFjZmYwOTk0NGMzZg==");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_NextInnovation_invokeConsumerSecret(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("Y3NfOTEzZTU2MmYyN2E3N2Q2M2U5MjEwZTQ1ZjUzZTg1OWQwZWQ3N2ExYg==");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_AppBaseUrl_invokeBaseUrl(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("aHR0cDovL25leHQtaW5ub3ZhdGlvbi5jby5pZC9rdWxpdG1hZ2V0YW4v");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_ApiUrl_invokeAuthUrl(JNIEnv *env, jobject instance) {
    // -> api/user/generate_auth_cookie
    return env->NewStringUTF("YXBpL3VzZXIvZ2VuZXJhdGVfYXV0aF9jb29raWU=");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_ApiUrl_invokeRegistUrl(JNIEnv *env, jobject instance) {
    // -> wp-json/wc/v2/customers
    return env->NewStringUTF("d3AtanNvbi93Yy92Mi9jdXN0b21lcnM=");
}
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_store_data_network_ApiUrl_invokeCategoriesUrl(JNIEnv *env, jobject instance) {
    // -> wp-json/wc/v2/products/categories
    return env->NewStringUTF("d3AtanNvbi93Yy92Mi9wcm9kdWN0cy9jYXRlZ29yaWVz");
}
}
