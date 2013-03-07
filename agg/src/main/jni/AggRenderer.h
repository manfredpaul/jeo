/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_jeo_agg_AggRenderer */

#ifndef _Included_org_jeo_agg_AggRenderer
#define _Included_org_jeo_agg_AggRenderer
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    createRenderingPipeline
 * Signature: (III)J
 */
JNIEXPORT jlong JNICALL Java_org_jeo_agg_AggRenderer_createRenderingPipeline
  (JNIEnv *, jobject, jint, jint, jint);

/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    setTransform
 * Signature: (JDDDD)V
 */
JNIEXPORT void JNICALL Java_org_jeo_agg_AggRenderer_setTransform
  (JNIEnv *, jobject, jlong, jdouble, jdouble, jdouble, jdouble);

/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    drawLine
 * Signature: (JLorg/jeo/agg/VertexSource;[FFBB[D)V
 */
JNIEXPORT void JNICALL Java_org_jeo_agg_AggRenderer_drawLine
  (JNIEnv *, jobject, jlong, jobject, jfloatArray, jfloat, jbyte, jbyte, jdoubleArray);

/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    drawPolygon
 * Signature: (JLorg/jeo/agg/VertexSource;[F[FF)V
 */
JNIEXPORT void JNICALL Java_org_jeo_agg_AggRenderer_drawPolygon
  (JNIEnv *, jobject, jlong, jobject, jfloatArray, jfloatArray, jfloat);

/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    writePPM
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_jeo_agg_AggRenderer_writePPM
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     org_jeo_agg_AggRenderer
 * Method:    data
 * Signature: (J)[I
 */
JNIEXPORT jintArray JNICALL Java_org_jeo_agg_AggRenderer_data
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
/* Header for class org_jeo_agg_AggRenderer_LineCap */

#ifndef _Included_org_jeo_agg_AggRenderer_LineCap
#define _Included_org_jeo_agg_AggRenderer_LineCap
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
}
#endif
#endif
/* Header for class org_jeo_agg_AggRenderer_LineJoin */

#ifndef _Included_org_jeo_agg_AggRenderer_LineJoin
#define _Included_org_jeo_agg_AggRenderer_LineJoin
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
}
#endif
#endif
