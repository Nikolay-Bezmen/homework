package edu.hw11.Task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
public class FibonacciGenerator {
    public Class<?> generateFibonacciClass() {
        return new ByteBuddy()
            .subclass(Object.class)
            .name("FibonacciCounter")
            .defineMethod("calculateFibonacci", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameter(int.class, "n")
            .intercept(new Implementation.Simple(new FibonacciByteCodeAppender()))
            .make()
            .load(ClassLoader.getSystemClassLoader())
            .getLoaded();
    }

    private static class FibonacciByteCodeAppender implements ByteCodeAppender {
        @Override
        public @NotNull Size apply(
            MethodVisitor methodVisitor,
            Implementation.@NotNull Context context,
            @NotNull MethodDescription methodDescription
        ) {
            Label startLabel = new Label();
            Label loopLabel = new Label();
            Label endLabel = new Label();

            methodVisitor.visitCode();
            generateInitialInstructions(methodVisitor, startLabel);
            generateStartInstructions(methodVisitor, startLabel, loopLabel);
            generateLoopInstructions(methodVisitor, loopLabel, endLabel);
            generateEndInstructions(methodVisitor, endLabel);

            methodVisitor.visitEnd();

            return new Size(4, 8);
        }

        private void generateInitialInstructions(MethodVisitor methodVisitor, Label startLabel) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitJumpInsn(Opcodes.IFNE, startLabel);
            methodVisitor.visitInsn(Opcodes.LCONST_0);
            methodVisitor.visitInsn(Opcodes.LRETURN);
            methodVisitor.visitFrame(Opcodes.F_FULL, 1, new Object[] {Opcodes.INTEGER}, 0, new Object[] {});
        }

        private void generateStartInstructions(MethodVisitor methodVisitor, Label startLabel, Label loopLabel) {
            methodVisitor.visitLabel(startLabel);
            methodVisitor.visitInsn(Opcodes.LCONST_0);
            methodVisitor.visitVarInsn(Opcodes.LSTORE, 1);
            methodVisitor.visitInsn(Opcodes.LCONST_1);
            methodVisitor.visitVarInsn(Opcodes.LSTORE, 3);
            methodVisitor.visitInsn(Opcodes.ICONST_0);
            methodVisitor.visitVarInsn(Opcodes.ISTORE, 5);
            methodVisitor.visitFrame(
                Opcodes.F_FULL,
                4,
                new Object[] {Opcodes.INTEGER, Opcodes.LONG, Opcodes.LONG, Opcodes.INTEGER},
                0,
                new Object[] {}
            );
            methodVisitor.visitLabel(loopLabel);
        }

        private void generateLoopInstructions(MethodVisitor methodVisitor, Label loopLabel, Label endLabel) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 5);
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, endLabel);
            methodVisitor.visitVarInsn(Opcodes.LLOAD, 3);
            methodVisitor.visitVarInsn(Opcodes.LSTORE, 6);
            methodVisitor.visitVarInsn(Opcodes.LLOAD, 1);
            methodVisitor.visitVarInsn(Opcodes.LLOAD, 3);
            methodVisitor.visitInsn(Opcodes.LADD);
            methodVisitor.visitVarInsn(Opcodes.LSTORE, 3);
            methodVisitor.visitVarInsn(Opcodes.LLOAD, 6);
            methodVisitor.visitVarInsn(Opcodes.LSTORE, 1);
            methodVisitor.visitIincInsn(5, 1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, loopLabel);
        }

        private void generateEndInstructions(MethodVisitor methodVisitor, Label endLabel) {
            methodVisitor.visitFrame(
                Opcodes.F_FULL,
                4,
                new Object[] {Opcodes.INTEGER, Opcodes.LONG, Opcodes.LONG, Opcodes.INTEGER},
                0,
                new Object[] {}
            );
            methodVisitor.visitLabel(endLabel);
            methodVisitor.visitVarInsn(Opcodes.LLOAD, 1);
            methodVisitor.visitInsn(Opcodes.LRETURN);
        }
    }
}
