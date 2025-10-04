# PACKAGECONFIG:append:rpi = " \
#     accessibility \
#     egl \
#     eglfs \
#     fontconfig \ 
#     gles2 \
#     linuxfb \
#     tslib \ 
#     gbm \ 
#     kms \
# "
PACKAGECONFIG:append = "sql-sqlite"

# EXTRA_OECMAKE += "\
#     -DQT_FEATURE_egl=ON \
#     -DQT_FEATURE_eglfs=ON \
#     -DQT_FEATURE_opengl=ON \
#     -DQT_FEATURE_opengles2=ON \
#     -DQT_FEATURE_accessibility=ON \
# "