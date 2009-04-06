//++++++++++++++++++++++++++++++++++++++++++++++++++++++//
//     Fuzzy Inference Engine simpleEnjuiciamiento      //
//++++++++++++++++++++++++++++++++++++++++++++++++++++++//

package eia.fuzzy;

public class SimpleEnjuiciamiento implements FuzzyInferenceEngine {

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function of an input variable       //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private abstract class InnerMembershipFunction {
  double min, max, step;
  abstract double param(int i);
  double center() { return 0; }
  double basis() { return 0; }
  abstract double isEqual(double x);

  double isSmallerOrEqual(double x) {
   double degree=0, mu;
   for(double y=max; y>=x ; y-=step) if((mu = isEqual(y))>degree) degree=mu;
   return degree;
  }

  double isGreaterOrEqual(double x) {
   double degree=0, mu;
   for(double y=min; y<=x ; y+=step) if((mu = isEqual(y))>degree) degree=mu;
   return degree;
  }

  double isEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isGreaterOrEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isGreaterOrEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isGreaterOrEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0,greq=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>greq ) greq = mu2;
    if( mu1<greq ) minmu = mu1; else minmu = greq;
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSmallerOrEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isSmallerOrEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isSmallerOrEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0,smeq=0;
   for(double x=max; x>=min; x-=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>smeq ) smeq = mu2;
    if( mu1<smeq ) minmu = mu1; else minmu = smeq;
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isGreater(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isSmallerOrEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isSmallerOrEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,gr,degree=0,smeq=0;
   for(double x=max; x>=min; x-=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>smeq ) smeq = mu2;
    gr = op.not(smeq);
    minmu = ( mu1<gr ? mu1 : gr);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSmaller(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isGreaterOrEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isGreaterOrEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,sm,degree=0,greq=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>greq ) greq = mu2;
    sm = op.not(greq);
    minmu = ( mu1<sm ? mu1 : sm);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isNotEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.not(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isApproxEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.moreorless(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.moreorless(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.moreorless(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isVeryEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.very(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.very(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.very(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSlightlyEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.slightly(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.slightly(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.slightly(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //          Abstract class of an operator set          //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private abstract class InnerOperatorset {
  abstract double and(double a, double b);
  abstract double or(double a, double b);
  abstract double also(double a, double b);
  abstract double imp(double a, double b);
  abstract double not(double a);
  abstract double very(double a);
  abstract double moreorless(double a);
  abstract double slightly(double a);
  abstract double defuz(OutputMembershipFunction mf);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Class for the conclusion of a fuzzy rule       //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class InnerConclusion {
  private double degree;
  private InnerMembershipFunction mf;
  private InnerOperatorset op;

  InnerConclusion(double degree, InnerMembershipFunction mf, InnerOperatorset op) {
   this.op = op;
   this.degree = degree;
   this.mf = mf;
  }

  public double degree() { return degree; }
  public double compute(double x) { return op.imp(degree,mf.isEqual(x)); }
  public double center() { return mf.center(); }
  public double basis() { return mf.basis(); }
  public double param(int i) { return mf.param(i); }
  public double min() { return mf.min; }
  public double max() { return mf.max; }
  public double step() { return mf.step; }
  public boolean isSingleton() {
   return mf.getClass().getName().endsWith("MF_xfl_singleton");
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function of an output variable      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class OutputMembershipFunction implements MembershipFunction {
  public InnerConclusion[] conc;
  public double[] input;
  private InnerOperatorset op;

  OutputMembershipFunction() {
   this.conc = new InnerConclusion[0];
  }

  public void set(int size, InnerOperatorset op, double[] input) {
   this.input = input;
   this.op = op;
   this.conc = new InnerConclusion[size];
  }

  public void set(int pos, double dg, InnerMembershipFunction imf) {
   this.conc[pos] = new InnerConclusion(dg,imf,op);
  }

  public double compute(double x) {
   double dom = conc[0].compute(x);
   for(int i=1; i<conc.length; i++) dom = op.also(dom,conc[i].compute(x));
   return dom;
  }

  public double defuzzify() {
   return op.defuz(this);
  }

  public double min() {
   return conc[0].min();
  }

  public double max() {
   return conc[0].max();
  }

  public double step() {
   return conc[0].step();
  }

  public boolean isDiscrete() {
   for(int i=0; i<conc.length; i++) if(!conc[i].isSingleton()) return false;
   return true;
  }

  public double[][] getDiscreteValues() {
   double[][] value = new double[conc.length][2];
   for(int i=0; i<conc.length; i++) {
    value[i][0] = conc[i].param(0);
    value[i][1] = conc[i].degree();
   }
   return value;
  }

 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function MF_xfl_triangle      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

  private class MF_xfl_triangle extends InnerMembershipFunction {
   double a;
   double b;
   double c;

   MF_xfl_triangle( double min, double max, double step, double param[]){
    super.min = min;
    super.max = max;
    super.step = step;
    this.a = param[0];
    this.b = param[1];
    this.c = param[2];
   }
   double param(int _i) {
    switch(_i) {
     case 0: return a;
     case 1: return b;
     case 2: return c;
     default: return 0;
    }
   }
   double isEqual(double x) {
    return (a<x && x<=b? (x-a)/(b-a) : (b<x && x<c? (c-x)/(c-b) : 0));
   }
   double isGreaterOrEqual(double x) {
    return (x<a? 0 : (x>b? 1 : (x-a)/(b-a) ));
   }
   double isSmallerOrEqual(double x) {
    return (x<b? 1 : (x>c? 0 : (c-x)/(c-b) ));
   }
   double center() {
    return b;
   }
   double basis() {
    return (c-a);
   }
  }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function MF_xfl_trapezoid      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

  private class MF_xfl_trapezoid extends InnerMembershipFunction {
   double a;
   double b;
   double c;
   double d;

   MF_xfl_trapezoid( double min, double max, double step, double param[]){
    super.min = min;
    super.max = max;
    super.step = step;
    this.a = param[0];
    this.b = param[1];
    this.c = param[2];
    this.d = param[3];
   }
   double param(int _i) {
    switch(_i) {
     case 0: return a;
     case 1: return b;
     case 2: return c;
     case 3: return d;
     default: return 0;
    }
   }
   double isEqual(double x) {
    return (x<a || x>d? 0: (x<b? (x-a)/(b-a) : (x<c?1 : (d-x)/(d-c))));
   }
   double isGreaterOrEqual(double x) {
    return (x<a? 0 : (x>b? 1 : (x-a)/(b-a) ));
   }
   double isSmallerOrEqual(double x) {
    return (x<c? 1 : (x>d? 0 : (d-x)/(d-c) ));
   }
   double center() {
    return (b+c)/2;
   }
   double basis() {
    return (d-a);
   }
  }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //     Operator set OP_opAnd      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class OP_opAnd extends InnerOperatorset {
  double and(double a, double b) {
    return a*b;
  }
  double or(double a, double b) {
    return (a>b? a : b);
  }
  double also(double a, double b) {
    return (a>b? a : b);
  }
  double imp(double a, double b) {
    return (a<b? a : b);
  }
  double not(double a) {
    return 1-a;
  }
  double very(double a) {
   double w = 2.0;
    return Math.pow(a,w);
  }
  double moreorless(double a) {
   double w = 0.5;
    return Math.pow(a,w);
  }
  double slightly(double a) {
    return 4*a*(1-a);
  }
 double defuz(OutputMembershipFunction mf) {
   double min = mf.min();
   double max = mf.max();
   double step = mf.step();
  double num=0, denom=0;
  for(double x=min; x<=max; x+=step) {
   double m = mf.compute(x);
   num += x*m;
   denom += m;
  }
  if(denom==0) return (min+max)/2;
  return num/denom;
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_tModificacion  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_tModificacion {
  private double min = 0.0;
  private double max = 1.0;
  private double step = 0.00392156862745098;
  double _p_poco[] = { -1.0,0.0,1.0 };
  double _p_mucho[] = { 0.0,1.0,2.0 };
  MF_xfl_triangle poco = new MF_xfl_triangle(min,max,step,_p_poco);
  MF_xfl_triangle mucho = new MF_xfl_triangle(min,max,step,_p_mucho);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_tEfecto  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_tEfecto {
  private double min = 0.0;
  private double max = 1.0;
  private double step = 0.00392156862745098;
  double _p_despreciable[] = { -0.2,0.0,0.2,0.6000000000000001 };
  double _p_significativo[] = { 0.2,0.4000000000000001,1.0,1.2000000000000002 };
  MF_xfl_trapezoid despreciable = new MF_xfl_trapezoid(min,max,step,_p_despreciable);
  MF_xfl_trapezoid significativo = new MF_xfl_trapezoid(min,max,step,_p_significativo);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_ruleEfecto  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_ruleEfecto(MembershipFunction med, MembershipFunction recs, MembershipFunction pf) {
  double _rl;
  double _input[] = new double[3];
  if(med instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) med).getValue();
  if(recs instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) recs).getValue();
  if(pf instanceof FuzzySingleton)
   _input[2] = ((FuzzySingleton) pf).getValue();
  OP_opAnd _op = new OP_opAnd();
  OutputMembershipFunction efec = new OutputMembershipFunction();
  efec.set(2,_op,_input);
  TP_tModificacion _t_med = new TP_tModificacion();
  TP_tModificacion _t_recs = new TP_tModificacion();
  TP_tModificacion _t_pf = new TP_tModificacion();
  TP_tEfecto _t_efec = new TP_tEfecto();
  int _i_efec=0;
  _rl = _op.and(_op.and(_t_med.poco.isEqual(med),_t_recs.poco.isEqual(recs)),_t_pf.poco.isEqual(pf));
  efec.set(_i_efec,_rl, _t_efec.despreciable); _i_efec++;
  _rl = _op.or(_op.or(_t_med.mucho.isEqual(med),_t_recs.mucho.isEqual(recs)),_t_pf.mucho.isEqual(pf));
  efec.set(_i_efec,_rl, _t_efec.significativo); _i_efec++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = efec;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //               Fuzzy Inference Engine                //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 public double[] crispInference(double[] _input) {
  MembershipFunction medioambiente = new FuzzySingleton(_input[0]);
  MembershipFunction recursosnaturales = new FuzzySingleton(_input[1]);
  MembershipFunction pffuncionamiento = new FuzzySingleton(_input[2]);
  MembershipFunction efecto;
  MembershipFunction[] _call;
  _call = RL_ruleEfecto(medioambiente,recursosnaturales,pffuncionamiento); efecto=_call[0];
  double _output[] = new double[1];
  if(efecto instanceof FuzzySingleton)
   _output[0] = ((FuzzySingleton) efecto).getValue();
  else _output[0] = ((OutputMembershipFunction) efecto).defuzzify();
  return _output;
 }

 public double[] crispInference(MembershipFunction[] _input) {
  MembershipFunction medioambiente = _input[0];
  MembershipFunction recursosnaturales = _input[1];
  MembershipFunction pffuncionamiento = _input[2];
  MembershipFunction efecto;
  MembershipFunction[] _call;
  _call = RL_ruleEfecto(medioambiente,recursosnaturales,pffuncionamiento); efecto=_call[0];
  double _output[] = new double[1];
  if(efecto instanceof FuzzySingleton)
   _output[0] = ((FuzzySingleton) efecto).getValue();
  else _output[0] = ((OutputMembershipFunction) efecto).defuzzify();
  return _output;
 }

 public MembershipFunction[] fuzzyInference(double[] _input) {
  MembershipFunction medioambiente = new FuzzySingleton(_input[0]);
  MembershipFunction recursosnaturales = new FuzzySingleton(_input[1]);
  MembershipFunction pffuncionamiento = new FuzzySingleton(_input[2]);
  MembershipFunction efecto;
  MembershipFunction[] _call;
  _call = RL_ruleEfecto(medioambiente,recursosnaturales,pffuncionamiento); efecto=_call[0];
  MembershipFunction _output[] = new MembershipFunction[1];
  _output[0] = efecto;
  return _output;
 }

 public MembershipFunction[] fuzzyInference(MembershipFunction[] _input) {
  MembershipFunction medioambiente = _input[0];
  MembershipFunction recursosnaturales = _input[1];
  MembershipFunction pffuncionamiento = _input[2];
  MembershipFunction efecto;
  MembershipFunction[] _call;
  _call = RL_ruleEfecto(medioambiente,recursosnaturales,pffuncionamiento); efecto=_call[0];
  MembershipFunction _output[] = new MembershipFunction[1];
  _output[0] = efecto;
  return _output;
 }

}
