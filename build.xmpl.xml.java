<?xml version="1.0" encoding="UTF-8"?>
<!--
*** GENERATED FROM project.xml - DO NOT EDIT  ***
***         EDIT ../build.xml INSTEAD         ***
For the purpose of easier reading the script
is divided into following sections:
  - initialization
  - compilation
  - jar
  - execution
  - debugging
  - javadoc
  - test compilation
  - test execution
  - test debugging
  - applet
  - cleanup
        -->
<project xmlns:j2seproject1="http://www.netbeans.org/ns/j2se-project/1" xmlns:j2seproject3="http://www.netbeans.org/ns/j2se-project/3" xmlns:jaxrpc="http://www.netbeans.org/ns/j2se-project/jax-rpc" basedir=".." default="default" name="University_Management_System-impl">
    <fail message="Please build using Ant 1.8.0 or higher.">
        <condition>
            <not>
                <antversion atleast="1.8.0"/>
            </not>
        </condition>
    </fail>
    <target depends="test,jar,javadoc" description="Build and test whole project." name="default"/>
    <!-- 
                ======================
                INITIALIZATION SECTION 
                ======================
            -->
    <target name="-pre-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="-pre-init" name="-init-private">
        <property file="nbproject/private/config.properties"/>
        <property file="nbproject/private/configs/${config}.properties"/>
        <property file="nbproject/private/private.properties"/>
    </target>
    <target depends="-pre-init,-init-private" name="-init-user">
        <property file="${user.properties.file}"/>
        <!-- The two properties below are usually overridden -->
        <!-- by the active platform. Just a fallback. -->
        <property name="default.javac.source" value="1.6"/>
        <property name="default.javac.target" value="1.6"/>
    </target>
    <target depends="-pre-init,-init-private,-init-user" name="-init-project">
        <property file="nbproject/configs/${config}.properties"/>
        <property file="nbproject/project.properties"/>
    </target>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-init-macrodef-property" name="-do-init">
        <property name="platform.java" value="${java.home}/bin/java"/>
        <available file="${manifest.file}" property="manifest.available"/>
        <condition property="splashscreen.available">
            <and>
                <not>
                    <equals arg1="${application.splash}" arg2="" trim="true"/>
                </not>
                <available file="${application.splash}"/>
            </and>
        </condition>
        <condition property="main.class.available">
            <and>
                <isset property="main.class"/>
                <not>
                    <equals arg1="${main.class}" arg2="" trim="true"/>
                </not>
            </and>
        </condition>
        <condition property="profile.available">
            <and>
                <isset property="javac.profile"/>
                <length length="0" string="${javac.profile}" when="greater"/>
                <matches pattern="((1\.[89])|9)(\..*)?" string="${javac.source}"/>
            </and>
        </condition>
        <condition property="do.archive">
            <or>
                <not>
                    <istrue value="${jar.archive.disabled}"/>
                </not>
                <istrue value="${not.archive.disabled}"/>
            </or>
        </condition>
        <condition property="do.mkdist">
            <and>
                <isset property="do.archive"/>
                <isset property="libs.CopyLibs.classpath"/>
                <not>
                    <istrue value="${mkdist.disabled}"/>
                </not>
            </and>
        </condition>
        <condition property="do.archive+manifest.available">
            <and>
                <isset property="manifest.available"/>
                <istrue value="${do.archive}"/>
            </and>
        </condition>
        <condition property="do.archive+main.class.available">
            <and>
                <isset property="main.class.available"/>
                <istrue value="${do.archive}"/>
            </and>
        </condition>
        <condition property="do.archive+splashscreen.available">
            <and>
                <isset property="splashscreen.available"/>
                <istrue value="${do.archive}"/>
            </and>
        </condition>
        <condition property="do.archive+profile.available">
            <and>
                <isset property="profile.available"/>
                <istrue value="${do.archive}"/>
            </and>
        </condition>
        <condition property="have.tests">
            <or>
                <available file="${test.src.dir}"/>
            </or>
        </condition>
        <condition property="have.sources">
            <or>
                <available file="${src.dir}"/>
            </or>
        </condition>
        <condition property="netbeans.home+have.tests">
            <and>
                <isset property="netbeans.home"/>
                <isset property="have.tests"/>
            </and>
        </condition>
        <condition property="no.javadoc.preview">
            <and>
                <isset property="javadoc.preview"/>
                <isfalse value="${javadoc.preview}"/>
            </and>
        </condition>
        <property name="run.jvmargs" value=""/>
        <property name="run.jvmargs.ide" value=""/>
        <property name="javac.compilerargs" value=""/>
        <property name="work.dir" value="${basedir}"/>
        <condition property="no.deps">
            <and>
                <istrue value="${no.dependencies}"/>
            </and>
        </condition>
        <property name="javac.debug" value="true"/>
        <property name="javadoc.preview" value="true"/>
        <property name="application.args" value=""/>
        <property name="source.encoding" value="${file.encoding}"/>
        <property name="runtime.encoding" value="${source.encoding}"/>
        <property name="manifest.encoding" value="${source.encoding}"/>
        <condition property="javadoc.encoding.used" value="${javadoc.encoding}">
            <and>
                <isset property="javadoc.encoding"/>
                <not>
                    <equals arg1="${javadoc.encoding}" arg2=""/>
                </not>
            </and>
        </condition>
        <property name="javadoc.encoding.used" value="${source.encoding}"/>
        <property name="includes" value="**"/>
        <property name="excludes" value=""/>
        <property name="do.depend" value="false"/>
        <condition property="do.depend.true">
            <istrue value="${do.depend}"/>
        </condition>
        <path id="endorsed.classpath.path" path="${endorsed.classpath}"/>
        <condition else="" property="endorsed.classpath.cmd.line.arg" value="-Xbootclasspath/p:'${toString:endorsed.classpath.path}'">
            <and>
                <isset property="endorsed.classpath"/>
                <not>
                    <equals arg1="${endorsed.classpath}" arg2="" trim="true"/>
                </not>
            </and>
        </condition>
        <condition else="" property="javac.profile.cmd.line.arg" value="-profile ${javac.profile}">
            <isset property="profile.available"/>
        </condition>
        <condition else="false" property="jdkBug6558476">
            <and>
                <matches pattern="1\.[56]" string="${java.specification.version}"/>
                <not>
                    <os family="unix"/>
                </not>
            </and>
        </condition>
        <condition else="false" property="javac.fork">
            <or>
                <istrue value="${jdkBug6558476}"/>
                <istrue value="${javac.external.vm}"/>
            </or>
        </condition>
        <property name="jar.index" value="false"/>
        <property name="jar.index.metainf" value="${jar.index}"/>
        <property name="copylibs.rebase" value="true"/>
        <available file="${meta.inf.dir}/persistence.xml" property="has.persistence.xml"/>
        <condition property="junit.available">
            <or>
                <available classname="org.junit.Test" classpath="${run.test.classpath}"/>
                <available classname="junit.framework.Test" classpath="${run.test.classpath}"/>
            </or>
        </condition>
        <condition property="testng.available">
            <available classname="org.testng.annotations.Test" classpath="${run.test.classpath}"/>
        </condition>
        <condition property="junit+testng.available">
            <and>
                <istrue value="${junit.available}"/>
                <istrue value="${testng.available}"/>
            </and>
        </condition>
        <condition else="testng" property="testng.mode" value="mixed">
            <istrue value="${junit+testng.available}"/>
        </condition>
        <condition else="" property="testng.debug.mode" value="-mixed">
            <istrue value="${junit+testng.available}"/>
        </condition>
        <property name="java.failonerror" value="true"/>
    </target>
    <target name="-post-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-do-init" name="-init-check">
        <fail unless="src.dir">Must set src.dir</fail>
        <fail unless="test.src.dir">Must set test.src.dir</fail>
        <fail unless="build.dir">Must set build.dir</fail>
        <fail unless="dist.dir">Must set dist.dir</fail>
        <fail unless="build.classes.dir">Must set build.classes.dir</fail>
        <fail unless="dist.javadoc.dir">Must set dist.javadoc.dir</fail>
        <fail unless="build.test.classes.dir">Must set build.test.classes.dir</fail>
        <fail unless="build.test.results.dir">Must set build.test.results.dir</fail>
        <fail unless="build.classes.excludes">Must set build.classes.excludes</fail>
        <fail unless="dist.jar">Must set dist.jar</fail>
    </target>
    <target name="-init-macrodef-property">
        <macrodef name="property" uri="http://www.netbeans.org/ns/j2se-project/1">
            <attribute name="name"/>
            <attribute name="value"/>
            <sequential>
                <property name="@{name}" value="${@{value}}"/>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-ap-cmdline-properties" if="ap.supported.internal" name="-init-macrodef-javac-with-processors">
        <macrodef name="javac" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}" name="classpath"/>
            <attribute default="${javac.processorpath}" name="processorpath"/>
            <attribute default="${build.generated.sources.dir}/ap-source-output" name="apgeneratedsrcdir"/>
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="${javac.debug}" name="debug"/>
            <attribute default="${empty.dir}" name="sourcepath"/>
            <attribute default="${empty.dir}" name="gensrcdir"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property location="${build.dir}/empty" name="empty.dir"/>
                <mkdir dir="${empty.dir}"/>
                <mkdir dir="@{apgeneratedsrcdir}"/>
                <javac debug="@{debug}" deprecation="${javac.deprecation}" destdir="@{destdir}" encoding="${source.encoding}" excludes="@{excludes}" fork="${javac.fork}" includeantruntime="false" includes="@{includes}" source="${javac.source}" sourcepath="@{sourcepath}" srcdir="@{srcdir}" target="${javac.target}" tempdir="${java.io.tmpdir}">
                    <src>
                        <dirset dir="@{gensrcdir}" erroronmissingdir="false">
                            <include name="*"/>
                        </dirset>
                    </src>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <compilerarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <compilerarg line="${javac.profile.cmd.line.arg}"/>
                    <compilerarg line="${javac.compilerargs}"/>
                    <compilerarg value="-processorpath"/>
                    <compilerarg path="@{processorpath}:${empty.dir}"/>
                    <compilerarg line="${ap.processors.internal}"/>
                    <compilerarg line="${annotation.processing.processor.options}"/>
                    <compilerarg value="-s"/>
                    <compilerarg path="@{apgeneratedsrcdir}"/>
                    <compilerarg line="${ap.proc.none.internal}"/>
                    <customize/>
                </javac>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-ap-cmdline-properties" name="-init-macrodef-javac-without-processors" unless="ap.supported.internal">
        <macrodef name="javac" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}" name="classpath"/>
            <attribute default="${javac.processorpath}" name="processorpath"/>
            <attribute default="${build.generated.sources.dir}/ap-source-output" name="apgeneratedsrcdir"/>
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="${javac.debug}" name="debug"/>
            <attribute default="${empty.dir}" name="sourcepath"/>
            <attribute default="${empty.dir}" name="gensrcdir"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property location="${build.dir}/empty" name="empty.dir"/>
                <mkdir dir="${empty.dir}"/>
                <javac debug="@{debug}" deprecation="${javac.deprecation}" destdir="@{destdir}" encoding="${source.encoding}" excludes="@{excludes}" fork="${javac.fork}" includeantruntime="false" includes="@{includes}" source="${javac.source}" sourcepath="@{sourcepath}" srcdir="@{srcdir}" target="${javac.target}" tempdir="${java.io.tmpdir}">
                    <src>
                        <dirset dir="@{gensrcdir}" erroronmissingdir="false">
                            <include name="*"/>
                        </dirset>
                    </src>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <compilerarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <compilerarg line="${javac.profile.cmd.line.arg}"/>
                    <compilerarg line="${javac.compilerargs}"/>
                    <customize/>
                </javac>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-javac-with-processors,-init-macrodef-javac-without-processors" name="-init-macrodef-javac">
        <macrodef name="depend" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}" name="classpath"/>
            <sequential>
                <depend cache="${build.dir}/depcache" destdir="@{destdir}" excludes="${excludes}" includes="${includes}" srcdir="@{srcdir}">
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                </depend>
            </sequential>
        </macrodef>
        <macrodef name="force-recompile" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${build.classes.dir}" name="destdir"/>
            <sequential>
                <fail unless="javac.includes">Must set javac.includes</fail>
                <pathconvert pathsep="${line.separator}" property="javac.includes.binary">
                    <path>
                        <filelist dir="@{destdir}" files="${javac.includes}"/>
                    </path>
                    <globmapper from="*.java" to="*.class"/>
                </pathconvert>
                <tempfile deleteonexit="true" property="javac.includesfile.binary"/>
                <echo file="${javac.includesfile.binary}" message="${javac.includes.binary}"/>
                <delete>
                    <files includesfile="${javac.includesfile.binary}"/>
                </delete>
                <delete>
                    <fileset file="${javac.includesfile.binary}"/>
                </delete>
            </sequential>
        </macrodef>
    </target>
    <target if="${junit.available}" name="-init-macrodef-junit-init">
        <condition else="false" property="nb.junit.batch" value="true">
            <and>
                <istrue value="${junit.available}"/>
                <not>
                    <isset property="test.method"/>
                </not>
            </and>
        </condition>
        <condition else="false" property="nb.junit.single" value="true">
            <and>
                <istrue value="${junit.available}"/>
                <isset property="test.method"/>
            </and>
        </condition>
    </target>
    <target name="-init-test-properties">
        <property name="test.binaryincludes" value="&lt;nothing&gt;"/>
        <property name="test.binarytestincludes" value=""/>
        <property name="test.binaryexcludes" value=""/>
    </target>
    <target if="${nb.junit.single}" name="-init-macrodef-junit-single" unless="${nb.junit.batch}">
        <macrodef name="junit" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="junit.forkmode" value="perTest"/>
                <junit dir="${work.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" forkmode="${junit.forkmode}" showoutput="true" tempdir="${build.dir}">
                    <test methods="@{testmethods}" name="@{testincludes}" todir="${build.test.results.dir}"/>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-test-properties" if="${nb.junit.batch}" name="-init-macrodef-junit-batch" unless="${nb.junit.single}">
        <macrodef name="junit" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="junit.forkmode" value="perTest"/>
                <junit dir="${work.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" forkmode="${junit.forkmode}" showoutput="true" tempdir="${build.dir}">
                    <batchtest todir="${build.test.results.dir}">
                        <fileset dir="${test.src.dir}" excludes="@{excludes},${excludes}" includes="@{includes}">
                            <filename name="@{testincludes}"/>
                        </fileset>
                        <fileset dir="${build.test.classes.dir}" excludes="@{excludes},${excludes},${test.binaryexcludes}" includes="${test.binaryincludes}">
                            <filename name="${test.binarytestincludes}"/>
                        </fileset>
                    </batchtest>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-init,-init-macrodef-junit-single, -init-macrodef-junit-batch" if="${junit.available}" name="-init-macrodef-junit"/>
    <target if="${testng.available}" name="-init-macrodef-testng">
        <macrodef name="testng" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <condition else="" property="testng.methods.arg" value="@{testincludes}.@{testmethods}">
                    <isset property="test.method"/>
                </condition>
                <union id="test.set">
                    <fileset dir="${test.src.dir}" excludes="@{excludes},**/*.xml,${excludes}" includes="@{includes}">
                        <filename name="@{testincludes}"/>
                    </fileset>
                </union>
                <taskdef classname="org.testng.TestNGAntTask" classpath="${run.test.classpath}" name="testng"/>
                <testng classfilesetref="test.set" failureProperty="tests.failed" listeners="org.testng.reporters.VerboseReporter" methods="${testng.methods.arg}" mode="${testng.mode}" outputdir="${build.test.results.dir}" suitename="University_Management_System" testname="TestNG tests" workingDir="${work.dir}">
                    <xmlfileset dir="${build.test.classes.dir}" includes="@{testincludes}"/>
                    <propertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </propertyset>
                    <customize/>
                </testng>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-macrodef-test-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <echo>No tests executed.</echo>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit" if="${junit.available}" name="-init-macrodef-junit-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <j2seproject3:junit excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </j2seproject3:junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng" if="${testng.available}" name="-init-macrodef-testng-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <j2seproject3:testng excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </j2seproject3:testng>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-test-impl,-init-macrodef-junit-impl,-init-macrodef-testng-impl" name="-init-macrodef-test">
        <macrodef name="test" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <sequential>
                <j2seproject3:test-impl excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize>
                        <classpath>
                            <path path="${run.test.classpath}"/>
                        </classpath>
                        <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                        <jvmarg line="${run.jvmargs}"/>
                        <jvmarg line="${run.jvmargs.ide}"/>
                    </customize>
                </j2seproject3:test-impl>
            </sequential>
        </macrodef>
    </target>
    <target if="${junit.available}" name="-init-macrodef-junit-debug" unless="${nb.junit.batch}">
        <macrodef name="junit-debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="junit.forkmode" value="perTest"/>
                <junit dir="${work.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" forkmode="${junit.forkmode}" showoutput="true" tempdir="${build.dir}">
                    <test methods="@{testmethods}" name="@{testincludes}" todir="${build.test.results.dir}"/>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <jvmarg line="${debug-args-line}"/>
                    <jvmarg value="-Xrunjdwp:transport=${debug-transport},address=${jpda.address}"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-test-properties" if="${nb.junit.batch}" name="-init-macrodef-junit-debug-batch">
        <macrodef name="junit-debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="junit.forkmode" value="perTest"/>
                <junit dir="${work.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" forkmode="${junit.forkmode}" showoutput="true" tempdir="${build.dir}">
                    <batchtest todir="${build.test.results.dir}">
                        <fileset dir="${test.src.dir}" excludes="@{excludes},${excludes}" includes="@{includes}">
                            <filename name="@{testincludes}"/>
                        </fileset>
                        <fileset dir="${build.test.classes.dir}" excludes="@{excludes},${excludes},${test.binaryexcludes}" includes="${test.binaryincludes}">
                            <filename name="${test.binarytestincludes}"/>
                        </fileset>
                    </batchtest>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <jvmarg line="${debug-args-line}"/>
                    <jvmarg value="-Xrunjdwp:transport=${debug-transport},address=${jpda.address}"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-debug,-init-macrodef-junit-debug-batch" if="${junit.available}" name="-init-macrodef-junit-debug-impl">
        <macrodef name="test-debug-impl" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <j2seproject3:junit-debug excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </j2seproject3:junit-debug>
            </sequential>
        </macrodef>
    </target>
    <target if="${testng.available}" name="-init-macrodef-testng-debug">
        <macrodef name="testng-debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <element name="customize2" optional="true"/>
            <sequential>
                <condition else="-testclass @{testClass}" property="test.class.or.method" value="-methods @{testClass}.@{testMethod}">
                    <isset property="test.method"/>
                </condition>
                <condition else="-suitename University_Management_System -testname @{testClass} ${test.class.or.method}" property="testng.cmd.args" value="@{testClass}">
                    <matches pattern=".*\.xml" string="@{testClass}"/>
                </condition>
                <delete dir="${build.test.results.dir}" quiet="true"/>
                <mkdir dir="${build.test.results.dir}"/>
                <j2seproject3:debug classname="org.testng.TestNG" classpath="${debug.test.classpath}">
                    <customize>
                        <customize2/>
                        <jvmarg value="-ea"/>
                        <arg line="${testng.debug.mode}"/>
                        <arg line="-d ${build.test.results.dir}"/>
                        <arg line="-listener org.testng.reporters.VerboseReporter"/>
                        <arg line="${testng.cmd.args}"/>
                    </customize>
                </j2seproject3:debug>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng-debug" if="${testng.available}" name="-init-macrodef-testng-debug-impl">
        <macrodef name="testng-debug-impl" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <element implicit="true" name="customize2" optional="true"/>
            <sequential>
                <j2seproject3:testng-debug testClass="@{testClass}" testMethod="@{testMethod}">
                    <customize2/>
                </j2seproject3:testng-debug>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-debug-impl" if="${junit.available}" name="-init-macrodef-test-debug-junit">
        <macrodef name="test-debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <sequential>
                <j2seproject3:test-debug-impl excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize>
                        <classpath>
                            <path path="${run.test.classpath}"/>
                        </classpath>
                        <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                        <jvmarg line="${run.jvmargs}"/>
                        <jvmarg line="${run.jvmargs.ide}"/>
                    </customize>
                </j2seproject3:test-debug-impl>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng-debug-impl" if="${testng.available}" name="-init-macrodef-test-debug-testng">
        <macrodef name="test-debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <sequential>
                <j2seproject3:testng-debug-impl testClass="@{testClass}" testMethod="@{testMethod}">
                    <customize2>
                        <syspropertyset>
                            <propertyref prefix="test-sys-prop."/>
                            <mapper from="test-sys-prop.*" to="*" type="glob"/>
                        </syspropertyset>
                    </customize2>
                </j2seproject3:testng-debug-impl>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-test-debug-junit,-init-macrodef-test-debug-testng" name="-init-macrodef-test-debug"/>
    <!--
                pre NB7.2 profiling section; consider it deprecated
            -->
    <target depends="-profile-pre-init, init, -profile-post-init, -profile-init-macrodef-profile, -profile-init-check" if="profiler.info.jvmargs.agent" name="profile-init"/>
    <target if="profiler.info.jvmargs.agent" name="-profile-pre-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target if="profiler.info.jvmargs.agent" name="-profile-post-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target if="profiler.info.jvmargs.agent" name="-profile-init-macrodef-profile">
        <macrodef name="resolve">
            <attribute name="name"/>
            <attribute name="value"/>
            <sequential>
                <property name="@{name}" value="${env.@{value}}"/>
            </sequential>
        </macrodef>
        <macrodef name="profile">
            <attribute default="${main.class}" name="classname"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property environment="env"/>
                <resolve name="profiler.current.path" value="${profiler.info.pathvar}"/>
                <java classname="@{classname}" dir="${profiler.info.dir}" failonerror="${java.failonerror}" fork="true" jvm="${profiler.info.jvm}">
                    <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <jvmarg value="${profiler.info.jvmargs.agent}"/>
                    <jvmarg line="${profiler.info.jvmargs}"/>
                    <env key="${profiler.info.pathvar}" path="${profiler.info.agentpath}:${profiler.current.path}"/>
                    <arg line="${application.args}"/>
                    <classpath>
                        <path path="${run.classpath}"/>
                    </classpath>
                    <syspropertyset>
                        <propertyref prefix="run-sys-prop."/>
                        <mapper from="run-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <customize/>
                </java>
            </sequential>
        </macrodef>
    </target>
    <target depends="-profile-pre-init, init, -profile-post-init, -profile-init-macrodef-profile" if="profiler.info.jvmargs.agent" name="-profile-init-check">
        <fail unless="profiler.info.jvm">Must set JVM to use for profiling in profiler.info.jvm</fail>
        <fail unless="profiler.info.jvmargs.agent">Must set profiler agent JVM arguments in profiler.info.jvmargs.agent</fail>
    </target>
    <!--
                end of pre NB7.2 profiling section
            -->
    <target depends="-init-debug-args" name="-init-macrodef-nbjpda">
        <macrodef name="nbjpdastart" uri="http://www.netbeans.org/ns/j2se-project/1">
            <attribute default="${main.class}" name="name"/>
            <attribute default="${debug.classpath}" name="classpath"/>
            <attribute default="" name="stopclassname"/>
            <sequential>
                <nbjpdastart addressproperty="jpda.address" name="@{name}" stopclassname="@{stopclassname}" transport="${debug-transport}">
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                </nbjpdastart>
            </sequential>
        </macrodef>
        <macrodef name="nbjpdareload" uri="http://www.netbeans.org/ns/j2se-project/1">
            <attribute default="${build.classes.dir}" name="dir"/>
            <sequential>
                <nbjpdareload>
                    <fileset dir="@{dir}" includes="${fix.classes}">
                        <include name="${fix.includes}*.class"/>
                    </fileset>
                </nbjpdareload>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-debug-args">
        <property name="version-output" value="java version &quot;${ant.java.version}"/>
        <condition property="have-jdk-older-than-1.4">
            <or>
                <contains string="${version-output}" substring="java version &quot;1.0"/>
                <contains string="${version-output}" substring="java version &quot;1.1"/>
                <contains string="${version-output}" substring="java version &quot;1.2"/>
                <contains string="${version-output}" substring="java version &quot;1.3"/>
            </or>
        </condition>
        <condition else="-Xdebug" property="debug-args-line" value="-Xdebug -Xnoagent -Djava.compiler=none">
            <istrue value="${have-jdk-older-than-1.4}"/>
        </condition>
        <condition else="dt_socket" property="debug-transport-by-os" value="dt_shmem">
            <os family="windows"/>
        </condition>
        <condition else="${debug-transport-by-os}" property="debug-transport" value="${debug.transport}">
            <isset property="debug.transport"/>
        </condition>
    </target>
    <target depends="-init-debug-args" name="-init-macrodef-debug">
        <macrodef name="debug" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${main.class}" name="classname"/>
            <attribute default="${debug.classpath}" name="classpath"/>
            <element name="customize" optional="true"/>
            <sequential>
                <java classname="@{classname}" dir="${work.dir}" failonerror="${java.failonerror}" fork="true">
                    <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <jvmarg line="${debug-args-line}"/>
                    <jvmarg value="-Xrunjdwp:transport=${debug-transport},address=${jpda.address}"/>
                    <jvmarg value="-Dfile.encoding=${runtime.encoding}"/>
                    <redirector errorencoding="${runtime.encoding}" inputencoding="${runtime.encoding}" outputencoding="${runtime.encoding}"/>
                    <jvmarg line="${run.jvmargs}"/>
                    <jvmarg line="${run.jvmargs.ide}"/>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <syspropertyset>
                        <propertyref prefix="run-sys-prop."/>
                        <mapper from="run-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <customize/>
                </java>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-macrodef-java">
        <macrodef name="java" uri="http://www.netbeans.org/ns/j2se-project/1">
            <attribute default="${main.class}" name="classname"/>
            <attribute default="${run.classpath}" name="classpath"/>
            <attribute default="jvm" name="jvm"/>
            <element name="customize" optional="true"/>
            <sequential>
                <java classname="@{classname}" dir="${work.dir}" failonerror="${java.failonerror}" fork="true">
                    <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <jvmarg value="-Dfile.encoding=${runtime.encoding}"/>
                    <redirector errorencoding="${runtime.encoding}" inputencoding="${runtime.encoding}" outputencoding="${runtime.encoding}"/>
                    <jvmarg line="${run.jvmargs}"/>
                    <jvmarg line="${run.jvmargs.ide}"/>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <syspropertyset>
                        <propertyref prefix="run-sys-prop."/>
                        <mapper from="run-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <customize/>
                </java>
            </sequential>
        </macrodef>
    </target>
    </macrodef>
    </target>
    <target name="-init-macrodef-copylibs">
        <macrodef name="copylibs" uri="http://www.netbeans.org/ns/j2se-project/3">
            <attribute default="${manifest.file}" name="manifest"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property location="${build.classes.dir}" name="build.classes.dir.resolved"/>
                <pathconvert property="run.classpath.without.build.classes.dir">
                    <path path="${run.classpath}"/>
                    <map from="${build.classes.dir.resolved}" to=""/>
                </pathconvert>
                <pathconvert pathsep=" " property="jar.classpath">
                    <path path="${run.classpath.without.build.classes.dir}"/>
                    <chainedmapper>
                        <flattenmapper/>
                        <filtermapper>
                            <replacestring from=" " to="%20"/>
                        </filtermapper>
                        <globmapper from="*" to="lib/*"/>
                    </chainedmapper>
                </pathconvert>
                <taskdef classname="org.netbeans.modules.java.j2seproject.copylibstask.CopyLibs" classpath="${libs.CopyLibs.classpath}" name="copylibs"/>
                <copylibs compress="${jar.compress}" excludeFromCopy="${copylibs.excludes}" index="${jar.index}" indexMetaInf="${jar.index.metainf}" jarfile="${dist.jar}" manifest="@{manifest}" manifestencoding="UTF-8" rebase="${copylibs.rebase}" runtimeclasspath="${run.classpath.without.build.classes.dir}">
                    <fileset dir="${build.classes.dir}" excludes="${dist.archive.excludes}"/>
                    <manifest>
                        <attribute name="Class-Path" value="${jar.classpath}"/>
                        <customize/>
                    </manifest>
                </copylibs>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-presetdef-jar">
        <presetdef name="jar" uri="http://www.netbeans.org/ns/j2se-project/1">
            <jar compress="${jar.compress}" index="${jar.index}" jarfile="${dist.jar}" manifestencoding="UTF-8">
                <j2seproject1:fileset dir="${build.classes.dir}" excludes="${dist.archive.excludes}"/>
            </jar>
        </presetdef>
    </target>
    <target name="-init-ap-cmdline-properties">
        <property name="annotation.processing.enabled" value="true"/>
        <property name="annotation.processing.processors.list" value=""/>
        <property name="annotation.processing.processor.options" value=""/>
        <property name="annotation.processing.run.all.processors" value="true"/>
        <property name="javac.processorpath" value="${javac.classpath}"/>
        <property name="javac.test.processorpath" value="${javac.test.classpath}"/>
        <condition property="ap.supported.internal" value="true">
            <not>
                <matches pattern="1\.[0-5](\..*)?" string="${javac.source}"/>
            </not>
        </condition>
    </target>
    <target depends="-init-ap-cmdline-properties" if="ap.supported.internal" name="-init-ap-cmdline-supported">
        <condition else="" property="ap.processors.internal" value="-processor ${annotation.processing.processors.list}">
            <isfalse value="${annotation.processing.run.all.processors}"/>
        </condition>
        <condition else="" property="ap.proc.none.internal" value="-proc:none">
            <isfalse value="${annotation.processing.enabled}"/>
        </condition>
    </target>
    <target depends="-init-ap-cmdline-properties,-init-ap-cmdline-supported" name="-init-ap-cmdline">
        <property name="ap.cmd.line.internal" value=""/>
    </target>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-do-init,-post-init,-init-check,-init-macrodef-property,-init-macrodef-javac,-init-macrodef-test,-init-macrodef-test-debug,-init-macrodef-nbjpda,-init-macrodef-debug,-init-macrodef-java,-init-presetdef-jar,-init-ap-cmdline" name="init"/>
    <!--
                ===================
                COMPILATION SECTION
                ===================
            -->
    <target name="-deps-jar-init" unless="built-jar.properties">
        <property location="${build.dir}/built-jar.properties" name="built-jar.properties"/>
        <delete file="${built-jar.properties}" quiet="true"/>
    </target>
    <target if="already.built.jar.${basedir}" name="-warn-already-built-jar">
        <echo level="warn" message="Cycle detected: University Management System was already built"/>
    </target>
    <target depends="init,-deps-jar-init" name="deps-jar" unless="no.deps">
        <mkdir dir="${build.dir}"/>
        <touch file="${built-jar.properties}" verbose="false"/>
        <property file="${built-jar.properties}" prefix="already.built.jar."/>
        <antcall target="-warn-already-built-jar"/>
        <propertyfile file="${built-jar.properties}">
            <entry key="${basedir}" value=""/>
        </propertyfile>
    </target>
    <target depends="init,-check-automatic-build,-clean-after-automatic-build" name="-verify-automatic-build"/>
    <target depends="init" name="-check-automatic-build">
        <available file="${build.classes.dir}/.netbeans_automatic_build" property="netbeans.automatic.build"/>
    </target>
    <target depends="init" if="netbeans.automatic.build" name="-clean-after-automatic-build">
        <antcall target="clean"/>
    </target>
    <target depends="init,deps-jar" name="-pre-pre-compile">
        <mkdir dir="${build.classes.dir}"/>
    </target>
    <target name="-pre-compile">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target if="do.depend.true" name="-compile-depend">
        <pathconvert property="build.generated.subdirs">
            <dirset dir="${build.generated.sources.dir}" erroronmissingdir="false">
                <include name="*"/>
            </dirset>
        </pathconvert>
        <j2seproject3:depend srcdir="${src.dir}:${build.generated.subdirs}"/>
    </target>
    <target depends="init,deps-jar,-pre-pre-compile,-pre-compile, -copy-persistence-xml,-compile-depend" if="have.sources" name="-do-compile">
        <j2seproject3:javac gensrcdir="${build.generated.sources.dir}"/>
        <copy todir="${build.classes.dir}">
            <fileset dir="${src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target if="has.persistence.xml" name="-copy-persistence-xml">
        <mkdir dir="${build.classes.dir}/META-INF"/>
        <copy todir="${build.classes.dir}/META-INF">
            <fileset dir="${meta.inf.dir}" includes="persistence.xml orm.xml"/>
        </copy>
    </target>
    <target name="-post-compile">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-verify-automatic-build,-pre-pre-compile,-pre-compile,-do-compile,-post-compile" description="Compile project." name="compile"/>
    <target name="-pre-compile-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-pre-pre-compile" name="-do-compile-single">
        <fail unless="javac.includes">Must select some files in the IDE or set javac.includes</fail>
        <j2seproject3:force-recompile/>
        <j2seproject3:javac excludes="" gensrcdir="${build.generated.sources.dir}" includes="${javac.includes}" sourcepath="${src.dir}"/>
    </target>
    <target name="-post-compile-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-verify-automatic-build,-pre-pre-compile,-pre-compile-single,-do-compile-single,-post-compile-single" name="compile-single"/>
    <!--
                ====================
                JAR BUILDING SECTION
                ====================
            -->
    <target depends="init" name="-pre-pre-jar">
        <dirname file="${dist.jar}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
    </target>
    <target name="-pre-jar">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init" if="do.archive" name="-do-jar-create-manifest" unless="manifest.available">
        <tempfile deleteonexit="true" destdir="${build.dir}" property="tmp.manifest.file"/>
        <touch file="${tmp.manifest.file}" verbose="false"/>
    </target>
    <target depends="init" if="do.archive+manifest.available" name="-do-jar-copy-manifest">
        <tempfile deleteonexit="true" destdir="${build.dir}" property="tmp.manifest.file"/>
        <copy encoding="${manifest.encoding}" file="${manifest.file}" outputencoding="UTF-8" tofile="${tmp.manifest.file}"/>
    </target>
    <target depends="init,-do-jar-create-manifest,-do-jar-copy-manifest" if="do.archive+main.class.available" name="-do-jar-set-mainclass">
        <manifest encoding="UTF-8" file="${tmp.manifest.file}" mode="update">
            <attribute name="Main-Class" value="${main.class}"/>
        </manifest>
    </target>
    <target depends="init,-do-jar-create-manifest,-do-jar-copy-manifest" if="do.archive+profile.available" name="-do-jar-set-profile">
        <manifest encoding="UTF-8" file="${tmp.manifest.file}" mode="update">
            <attribute name="Profile" value="${javac.profile}"/>
        </manifest>
    </target>
    <target depends="init,-do-jar-create-manifest,-do-jar-copy-manifest" if="do.archive+splashscreen.available" name="-do-jar-set-splashscreen">
        <basename file="${application.splash}" property="splashscreen.basename"/>
        <mkdir dir="${build.classes.dir}/META-INF"/>
        <copy failonerror="false" file="${application.splash}" todir="${build.classes.dir}/META-INF"/>
        <manifest encoding="UTF-8" file="${tmp.manifest.file}" mode="update">
            <attribute name="SplashScreen-Image" value="META-INF/${splashscreen.basename}"/>
        </manifest>
    </target>
    <target depends="init,-init-macrodef-copylibs,compile,-pre-pre-jar,-pre-jar,-do-jar-create-manifest,-do-jar-copy-manifest,-do-jar-set-mainclass,-do-jar-set-profile,-do-jar-set-splashscreen" if="do.mkdist" name="-do-jar-copylibs">
        <j2seproject3:copylibs manifest="${tmp.manifest.file}"/>
        <echo level="info">To run this application from the command line without Ant, try:</echo>
        <property location="${dist.jar}" name="dist.jar.resolved"/>
        <echo level="info">java -jar "${dist.jar.resolved}"</echo>
    </target>
    <target depends="init,compile,-pre-pre-jar,-pre-jar,-do-jar-create-manifest,-do-jar-copy-manifest,-do-jar-set-mainclass,-do-jar-set-profile,-do-jar-set-splashscreen" if="do.archive" name="-do-jar-jar" unless="do.mkdist">
        <j2seproject1:jar manifest="${tmp.manifest.file}"/>
        <property location="${build.classes.dir}" name="build.classes.dir.resolved"/>
        <property location="${dist.jar}" name="dist.jar.resolved"/>
        <pathconvert property="run.classpath.with.dist.jar">
            <path path="${run.classpath}"/>
            <map from="${build.classes.dir.resolved}" to="${dist.jar.resolved}"/>
        </pathconvert>
        <condition else="" property="jar.usage.message" value="To run this application from the command line without Ant, try:${line.separator}${platform.java} -cp ${run.classpath.with.dist.jar} ${main.class}">
            <isset property="main.class.available"/>
        </condition>
        <condition else="debug" property="jar.usage.level" value="info">
            <isset property="main.class.available"/>
        </condition>
        <echo level="${jar.usage.level}" message="${jar.usage.message}"/>
    </target>
    <target depends="-do-jar-copylibs" if="do.archive" name="-do-jar-delete-manifest">
        <delete>
            <fileset file="${tmp.manifest.file}"/>
        </delete>
    </target>
    <target depends="init,compile,-pre-pre-jar,-pre-jar,-do-jar-create-manifest,-do-jar-copy-manifest,-do-jar-set-mainclass,-do-jar-set-profile,-do-jar-set-splashscreen,-do-jar-jar,-do-jar-delete-manifest" name="-do-jar-without-libraries"/>
    <target depends="init,compile,-pre-pre-jar,-pre-jar,-do-jar-create-manifest,-do-jar-copy-manifest,-do-jar-set-mainclass,-do-jar-set-profile,-do-jar-set-splashscreen,-do-jar-copylibs,-do-jar-delete-manifest" name="-do-jar-with-libraries"/>
    <target name="-post-jar">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-jar,-do-jar-without-libraries,-do-jar-with-libraries,-post-jar" name="-do-jar"/>
    <target depends="init,compile,-pre-jar,-do-jar,-post-jar" description="Build JAR." name="jar"/>
    <!--
                =================
                EXECUTION SECTION
                =================
            -->
    <target depends="init,compile" description="Run a main class." name="run">
        <j2seproject1:java>
            <customize>
                <arg line="${application.args}"/>
            </customize>
        </j2seproject1:java>
    </target>
    <target name="-do-not-recompile">
        <property name="javac.includes.binary" value=""/>
    </target>
    <target depends="init,compile-single" name="run-single">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <j2seproject1:java classname="${run.class}"/>
    </target>
    <target depends="init,compile-test-single" name="run-test-with-main">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <j2seproject1:java classname="${run.class}" classpath="${run.test.classpath}"/>
    </target>
    <!--
                =================
                DEBUGGING SECTION
                =================
            -->
    <target depends="init" if="netbeans.home" name="-debug-start-debugger">
        <j2seproject1:nbjpdastart name="${debug.class}"/>
    </target>
    <target depends="init" if="netbeans.home" name="-debug-start-debugger-main-test">
        <j2seproject1:nbjpdastart classpath="${debug.test.classpath}" name="${debug.class}"/>
    </target>
    <target depends="init,compile" name="-debug-start-debuggee">
        <j2seproject3:debug>
            <customize>
                <arg line="${application.args}"/>
            </customize>
        </j2seproject3:debug>
    </target>
    <target depends="init,compile,-debug-start-debugger,-debug-start-debuggee" description="Debug project in IDE." if="netbeans.home" name="debug"/>
    <target depends="init" if="netbeans.home" name="-debug-start-debugger-stepinto">
        <j2seproject1:nbjpdastart stopclassname="${main.class}"/>
    </target>
    <target depends="init,compile,-debug-start-debugger-stepinto,-debug-start-debuggee" if="netbeans.home" name="debug-stepinto"/>
    <target depends="init,compile-single" if="netbeans.home" name="-debug-start-debuggee-single">
        <fail unless="debug.class">Must select one file in the IDE or set debug.class</fail>
        <j2seproject3:debug classname="${debug.class}"/>
    </target>
    <target depends="init,compile-single,-debug-start-debugger,-debug-start-debuggee-single" if="netbeans.home" name="debug-single"/>
    <target depends="init,compile-test-single" if="netbeans.home" name="-debug-start-debuggee-main-test">
        <fail unless="debug.class">Must select one file in the IDE or set debug.class</fail>
        <j2seproject3:debug classname="${debug.class}" classpath="${debug.test.classpath}"/>
    </target>
    <target depends="init,compile-test-single,-debug-start-debugger-main-test,-debug-start-debuggee-main-test" if="netbeans.home" name="debug-test-with-main"/>
    <target depends="init" name="-pre-debug-fix">
        <fail unless="fix.includes">Must set fix.includes</fail>
        <property name="javac.includes" value="${fix.includes}.java"/>
    </target>
    <target depends="init,-pre-debug-fix,compile-single" if="netbeans.home" name="-do-debug-fix">
        <j2seproject1:nbjpdareload/>
    </target>
    <target depends="init,-pre-debug-fix,-do-debug-fix" if="netbeans.home" name="debug-fix"/>
    <!--
                =================
                PROFILING SECTION
                =================
            -->
    <!--
                pre NB7.2 profiler integration
            -->
    <target depends="profile-init,compile" description="Profile a project in the IDE." if="profiler.info.jvmargs.agent" name="-profile-pre72">
        <fail unless="netbeans.home">This target only works when run from inside the NetBeans IDE.</fail>
        <nbprofiledirect>
            <classpath>
                <path path="${run.classpath}"/>
            </classpath>
        </nbprofiledirect>
        <profile/>
    </target>
    <target depends="profile-init,compile-single" description="Profile a selected class in the IDE." if="profiler.info.jvmargs.agent" name="-profile-single-pre72">
        <fail unless="profile.class">Must select one file in the IDE or set profile.class</fail>
        <fail unless="netbeans.home">This target only works when run from inside the NetBeans IDE.</fail>
        <nbprofiledirect>
            <classpath>
                <path path="${run.classpath}"/>
            </classpath>
        </nbprofiledirect>
        <profile classname="${profile.class}"/>
    </target>
    <target depends="profile-init,compile-single" if="profiler.info.jvmargs.agent" name="-profile-applet-pre72">
        <fail unless="netbeans.home">This target only works when run from inside the NetBeans IDE.</fail>
        <nbprofiledirect>
            <classpath>
                <path path="${run.classpath}"/>
            </classpath>
        </nbprofiledirect>
        <profile classname="sun.applet.AppletViewer">
            <customize>
                <arg value="${applet.url}"/>
            </customize>
        </profile>
    </target>
    <target depends="profile-init,compile-test-single" if="profiler.info.jvmargs.agent" name="-profile-test-single-pre72">
        <fail unless="netbeans.home">This target only works when run from inside the NetBeans IDE.</fail>
        <nbprofiledirect>
            <classpath>
                <path path="${run.test.classpath}"/>
            </classpath>
        </nbprofiledirect>
        <junit dir="${profiler.info.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" jvm="${profiler.info.jvm}" showoutput="true">
            <env key="${profiler.info.pathvar}" path="${profiler.info.agentpath}:${profiler.current.path}"/>
            <jvmarg value="${profiler.info.jvmargs.agent}"/>
            <jvmarg line="${profiler.info.jvmargs}"/>
            <test name="${profile.class}"/>
            <classpath>
                <path path="${run.test.classpath}"/>
            </classpath>
            <syspropertyset>
                <propertyref prefix="test-sys-prop."/>
                <mapper from="test-sys-prop.*" to="*" type="glob"/>
            </syspropertyset>
            <formatter type="brief" usefile="false"/>
            <formatter type="xml"/>
        </junit>
    </target>
    <!--
                end of pre NB72 profiling section
            -->
    <target if="netbeans.home" name="-profile-check">
        <condition property="profiler.configured">
            <or>
                <contains casesensitive="true" string="${run.jvmargs.ide}" substring="-agentpath:"/>
                <contains casesensitive="true" string="${run.jvmargs.ide}" substring="-javaagent:"/>
            </or>
        </condition>
    </target>
    <target depends="-profile-check,-profile-pre72" description="Profile a project in the IDE." if="profiler.configured" name="profile" unless="profiler.info.jvmargs.agent">
        <startprofiler/>
        <antcall target="run"/>
    </target>
    <target depends="-profile-check,-profile-single-pre72" description="Profile a selected class in the IDE." if="profiler.configured" name="profile-single" unless="profiler.info.jvmargs.agent">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <startprofiler/>
        <antcall target="run-single"/>
    </target>
    <target depends="-profile-test-single-pre72" description="Profile a selected test in the IDE." name="profile-test-single"/>
    <target depends="-profile-check" description="Profile a selected test in the IDE." if="profiler.configured" name="profile-test" unless="profiler.info.jvmargs">
        <fail unless="test.includes">Must select some files in the IDE or set test.includes</fail>
        <startprofiler/>
        <antcall target="test-single"/>
    </target>
    <target depends="-profile-check" description="Profile a selected class in the IDE." if="profiler.configured" name="profile-test-with-main">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <startprofiler/>
        <antcall target="run-test-with-main"/>
    </target>
    <target depends="-profile-check,-profile-applet-pre72" if="profiler.configured" name="profile-applet" unless="profiler.info.jvmargs.agent">
        <fail unless="applet.url">Must select one file in the IDE or set applet.url</fail>
        <startprofiler/>
        <antcall target="run-applet"/>
    </target>
    <!--
                ===============
                JAVADOC SECTION
                ===============
            -->
    <target depends="init" if="have.sources" name="-javadoc-build">
        <mkdir dir="${dist.javadoc.dir}"/>
        <condition else="" property="javadoc.endorsed.classpath.cmd.line.arg" value="-J${endorsed.classpath.cmd.line.arg}">
            <and>
                <isset property="endorsed.classpath.cmd.line.arg"/>
                <not>
                    <equals arg1="${endorsed.classpath.cmd.line.arg}" arg2=""/>
                </not>
            </and>
        </condition>
        <condition else="" property="bug5101868workaround" value="*.java">
            <matches pattern="1\.[56](\..*)?" string="${java.version}"/>
        </condition>
        <javadoc additionalparam="-J-Dfile.encoding=${file.encoding} ${javadoc.additionalparam}" author="${javadoc.author}" charset="UTF-8" destdir="${dist.javadoc.dir}" docencoding="UTF-8" encoding="${javadoc.encoding.used}" failonerror="true" noindex="${javadoc.noindex}" nonavbar="${javadoc.nonavbar}" notree="${javadoc.notree}" private="${javadoc.private}" source="${javac.source}" splitindex="${javadoc.splitindex}" use="${javadoc.use}" useexternalfile="true" version="${javadoc.version}" windowtitle="${javadoc.windowtitle}">
            <classpath>
                <path path="${javac.classpath}"/>
            </classpath>
            <fileset dir="${src.dir}" excludes="${bug5101868workaround},${excludes}" includes="${includes}">
                <filename name="**/*.java"/>
            </fileset>
            <fileset dir="${build.generated.sources.dir}" erroronmissingdir="false">
                <include name="**/*.java"/>
                <exclude name="*.java"/>
            </fileset>
            <arg line="${javadoc.endorsed.classpath.cmd.line.arg}"/>
        </javadoc>
        <copy todir="${dist.javadoc.dir}">
            <fileset dir="${src.dir}" excludes="${excludes}" includes="${includes}">
                <filename name="**/doc-files/**"/>
            </fileset>
            <fileset dir="${build.generated.sources.dir}" erroronmissingdir="false">
                <include name="**/doc-files/**"/>
            </fileset>
        </copy>
    </target>
    <target depends="init,-javadoc-build" if="netbeans.home" name="-javadoc-browse" unless="no.javadoc.preview">
        <nbbrowse file="${dist.javadoc.dir}/index.html"/>
    </target>
    <target depends="init,-javadoc-build,-javadoc-browse" description="Build Javadoc." name="javadoc"/>
    <!--
                =========================
                TEST COMPILATION SECTION
                =========================
            -->
    <target depends="init,compile" if="have.tests" name="-pre-pre-compile-test">
        <mkdir dir="${build.test.classes.dir}"/>
    </target>
    <target name="-pre-compile-test">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target if="do.depend.true" name="-compile-test-depend">
        <j2seproject3:depend classpath="${javac.test.classpath}" destdir="${build.test.classes.dir}" srcdir="${test.src.dir}"/>
    </target>
    <target depends="init,deps-jar,compile,-pre-pre-compile-test,-pre-compile-test,-compile-test-depend" if="have.tests" name="-do-compile-test">
        <j2seproject3:javac apgeneratedsrcdir="${build.test.classes.dir}" classpath="${javac.test.classpath}" debug="true" destdir="${build.test.classes.dir}" processorpath="${javac.test.processorpath}" srcdir="${test.src.dir}"/>
        <copy todir="${build.test.classes.dir}">
            <fileset dir="${test.src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target name="-post-compile-test">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test,-do-compile-test,-post-compile-test" name="compile-test"/>
    <target name="-pre-compile-test-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,compile,-pre-pre-compile-test,-pre-compile-test-single" if="have.tests" name="-do-compile-test-single">
        <fail unless="javac.includes">Must select some files in the IDE or set javac.includes</fail>
        <j2seproject3:force-recompile destdir="${build.test.classes.dir}"/>
        <j2seproject3:javac apgeneratedsrcdir="${build.test.classes.dir}" classpath="${javac.test.classpath}" debug="true" destdir="${build.test.classes.dir}" excludes="" includes="${javac.includes}" processorpath="${javac.test.processorpath}" sourcepath="${test.src.dir}" srcdir="${test.src.dir}"/>
        <copy todir="${build.test.classes.dir}">
            <fileset dir="${test.src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target name="-post-compile-test-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test-single,-do-compile-test-single,-post-compile-test-single" name="compile-test-single"/>
    <!--
                =======================
                TEST EXECUTION SECTION
                =======================
            -->
    <target depends="init" if="have.tests" name="-pre-test-run">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test,-pre-test-run" if="have.tests" name="-do-test-run">
        <j2seproject3:test includes="${includes}" testincludes="**/*Test.java"/>
    </target>
    <target depends="init,compile-test,-pre-test-run,-do-test-run" if="have.tests" name="-post-test-run">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init" if="have.tests" name="test-report"/>
    <target depends="init" if="netbeans.home+have.tests" name="-test-browse"/>
    <target depends="init,compile-test,-pre-test-run,-do-test-run,test-report,-post-test-run,-test-browse" description="Run unit tests." name="test"/>
    <target depends="init" if="have.tests" name="-pre-test-run-single">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-do-test-run-single">
        <fail unless="test.includes">Must select some files in the IDE or set test.includes</fail>
        <j2seproject3:test excludes="" includes="${test.includes}" testincludes="${test.includes}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single" if="have.tests" name="-post-test-run-single">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single,-post-test-run-single" description="Run single unit test." name="test-single"/>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-do-test-run-single-method">
        <fail unless="test.class">Must select some files in the IDE or set test.class</fail>
        <fail unless="test.method">Must select some method in the IDE or set test.method</fail>
        <j2seproject3:test excludes="" includes="${javac.includes}" testincludes="${test.class}" testmethods="${test.method}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single-method" if="have.tests" name="-post-test-run-single-method">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single-method,-post-test-run-single-method" description="Run single unit test." name="test-single-method"/>
    <!--
                =======================
                TEST DEBUGGING SECTION
                =======================
            -->
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-debug-start-debuggee-test">
        <fail unless="test.class">Must select one file in the IDE or set test.class</fail>
        <j2seproject3:test-debug excludes="" includes="${javac.includes}" testClass="${test.class}" testincludes="${javac.includes}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-debug-start-debuggee-test-method">
        <fail unless="test.class">Must select one file in the IDE or set test.class</fail>
        <fail unless="test.method">Must select some method in the IDE or set test.method</fail>
        <j2seproject3:test-debug excludes="" includes="${javac.includes}" testClass="${test.class}" testMethod="${test.method}" testincludes="${test.class}" testmethods="${test.method}"/>
    </target>
    <target depends="init,compile-test" if="netbeans.home+have.tests" name="-debug-start-debugger-test">
        <j2seproject1:nbjpdastart classpath="${debug.test.classpath}" name="${test.class}"/>
    </target>
    <target depends="init,compile-test-single,-debug-start-debugger-test,-debug-start-debuggee-test" name="debug-test"/>
    <target depends="init,compile-test-single,-debug-start-debugger-test,-debug-start-debuggee-test-method" name="debug-test-method"/>
    <target depends="init,-pre-debug-fix,compile-test-single" if="netbeans.home" name="-do-debug-fix-test">
        <j2seproject1:nbjpdareload dir="${build.test.classes.dir}"/>
    </target>
    <target depends="init,-pre-debug-fix,-do-debug-fix-test" if="netbeans.home" name="debug-fix-test"/>
    <!--
                =========================
                APPLET EXECUTION SECTION
                =========================
            -->
    <target depends="init,compile-single" name="run-applet">
        <fail unless="applet.url">Must select one file in the IDE or set applet.url</fail>
        <j2seproject1:java classname="sun.applet.AppletViewer">
            <customize>
                <arg value="${applet.url}"/>
            </customize>
        </j2seproject1:java>
    </target>
    <!--
                =========================
                APPLET DEBUGGING  SECTION
                =========================
            -->
    <target depends="init,compile-single" if="netbeans.home" name="-debug-start-debuggee-applet">
        <fail unless="applet.url">Must select one file in the IDE or set applet.url</fail>
        <j2seproject3:debug classname="sun.applet.AppletViewer">
            <customize>
                <arg value="${applet.url}"/>
            </customize>
        </j2seproject3:debug>
    </target>
    <target depends="init,compile-single,-debug-start-debugger,-debug-start-debuggee-applet" if="netbeans.home" name="debug-applet"/>
    <!--
                ===============
                CLEANUP SECTION
                ===============
            -->
    <target name="-deps-clean-init" unless="built-clean.properties">
        <property location="${build.dir}/built-clean.properties" name="built-clean.properties"/>
        <delete file="${built-clean.properties}" quiet="true"/>
    </target>
    <target if="already.built.clean.${basedir}" name="-warn-already-built-clean">
        <echo level="warn" message="Cycle detected: University Management System was already built"/>
    </target>
    <target depends="init,-deps-clean-init" name="deps-clean" unless="no.deps">
        <mkdir dir="${build.dir}"/>
        <touch file="${built-clean.properties}" verbose="false"/>
        <property file="${built-clean.properties}" prefix="already.built.clean."/>
        <antcall target="-warn-already-built-clean"/>
        <propertyfile file="${built-clean.properties}">
            <entry key="${basedir}" value=""/>
        </propertyfile>
    </target>
    <target depends="init" name="-do-clean">
        <delete dir="${build.dir}"/>
        <delete dir="${dist.dir}" followsymlinks="false" includeemptydirs="true"/>
    </target>
    <target name="-post-clean">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-clean,-do-clean,-post-clean" description="Clean build products." name="clean"/>
    <target name="-check-call-dep">
        <property file="${call.built.properties}" prefix="already.built."/>
        <condition property="should.call.dep">
            <and>
                <not>
                    <isset property="already.built.${call.subproject}"/>
                </not>
                <available file="${call.script}"/>
            </and>
        </condition>
    </target>
    <target depends="-check-call-dep" if="should.call.dep" name="-maybe-call-dep">
        <ant antfile="${call.script}" inheritall="false" target="${call.target}">
            <propertyset>
                <propertyref prefix="transfer."/>
                <mapper from="transfer.*" to="*" type="glob"/>
            </propertyset>
        </ant>
    </target>
</project>